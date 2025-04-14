package com.springbootacedamy.oderoderdetailsmapstruct.service.impl;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.OderDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.OderDetailsDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderDetailsResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderOnlyResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.OderDetailsEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.OderEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.exception.NotFoundException;
import com.springbootacedamy.oderoderdetailsmapstruct.repo.*;
import com.springbootacedamy.oderoderdetailsmapstruct.service.OderService;
import com.springbootacedamy.oderoderdetailsmapstruct.util.mappers.OderDetailsMapper;
import com.springbootacedamy.oderoderdetailsmapstruct.util.mappers.OderMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class OderServiceIMPL implements OderService {

    @Autowired
    private OderRepo oderRepo;

    @Autowired
    private OderDetailsRepo oderDetailsRepo;

    @Autowired
    private OderMapper oderMapper;

    @Autowired
    private OderDetailsMapper oderDetailsMapper;

    @Autowired
    private CustomRepo customRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Transactional
    @Override
    public String saveOder(OderDTO oderDTO) {
        OderEntity oderEntity = new OderEntity(
                customRepo.getReferenceById(oderDTO.getCustomEntity()).getCustomerName(),
                oderDTO.getDate(),
                oderDTO.getCash(),
                employeeRepo.getReferenceById(oderDTO.getEmployeeEntity()).getEmployeeName(),
                customRepo.getReferenceById(oderDTO.getCustomEntity()),
                employeeRepo.getReferenceById(oderDTO.getEmployeeEntity())
        );
        oderRepo.save(oderEntity);

        if (oderRepo.existsById(oderEntity.getOderId())) {

            List<OderDetailsDTO> oderDetailsDTOList = oderDTO.getOderDetailsDTOList();
            List<OderDetailsEntity> oderDetailsEntityList = new ArrayList<>();

            for (OderDetailsDTO oderDetailsDTO : oderDetailsDTOList) {
                OderDetailsEntity oderDetailsEntity = new OderDetailsEntity(
                        itemRepo.getReferenceById(oderDetailsDTO.getItemEntity()).getItemName(),
                        oderDetailsDTO.getQty(),  //error
                        oderDetailsDTO.getMeasuringType(),
                        itemRepo.getReferenceById(oderDetailsDTO.getItemEntity()).getSupplyPrice() - itemRepo.getReferenceById(oderDetailsDTO.getItemEntity()).getSellPrice(),
                        itemRepo.getReferenceById(oderDetailsDTO.getItemEntity()).getSellPrice() * oderDetailsDTO.getQty(),  //error
                        oderEntity,
                        itemRepo.getReferenceById(oderDetailsDTO.getItemEntity())
                );
                oderDetailsEntityList.add(oderDetailsEntity);
                oderDetailsRepo.saveAll(oderDetailsEntityList);
            }
            double totalDiscount = 0;
            double netTotal = 0;
            for (int i = 0; i < oderDetailsEntityList.size(); i++) {
                totalDiscount += oderDetailsEntityList.get(i).getUnitDiscount();
                netTotal += oderDetailsEntityList.get(i).getTotal();
            }
            oderRepo.getReferenceById(oderEntity.getOderId()).setTotalDiscount(totalDiscount);
            oderRepo.getReferenceById(oderEntity.getOderId()).setNetTotal(netTotal);   //error

            oderRepo.getReferenceById(oderEntity.getOderId()).setNoOfItem(oderDetailsEntityList.size());
            oderRepo.getReferenceById(oderEntity.getOderId()).setBalance(oderRepo.getReferenceById(oderEntity.getOderId()).getCash() - oderRepo.getReferenceById(oderEntity.getOderId()).getNetTotal());  //error

            if (oderDetailsDTOList.size() > 0) {
                oderDetailsRepo.saveAll(oderDetailsEntityList);
                oderRepo.save(oderEntity);
            }
        }
        return "saved";
    }

    /*
        @Transactional
        @Override
        public String saveOderWithMapper(OderDTO oderDTO) {

            OderEntity oderEntity = modelMapper.map(oderDTO, OderEntity.class);

            if (oderRepo.existsById(oderEntity.getOderId())) {

                oderRepo.getReferenceById(oderEntity.getOderId()).setCustomName(customRepo.getReferenceById(oderDTO.getCustomEntity()).getCustomerName());
                oderRepo.getReferenceById(oderEntity.getOderId()).setCustomEntity(customRepo.getReferenceById(oderDTO.getCustomEntity()));
                oderRepo.getReferenceById(oderEntity.getOderId()).setCashier(employeeRepo.getReferenceById(oderDTO.getEmployeeEntity()).getEmployeeName());
                oderRepo.getReferenceById(oderEntity.getOderId()).setEmployeeEntity(employeeRepo.getReferenceById(oderDTO.getEmployeeEntity()));


                List<OderDetailsEntity> oderDetailsEntityList = modelMapper.map(oderDTO.getOderDetailsDTOList(), new TypeToken<List<OderDetailsEntity>>() {
                }.getType());

                if (oderDetailsEntityList.size() > 0) {

                    for (int i = 0; i < oderDetailsEntityList.size(); i++) {

                        oderDetailsEntityList.get(i).setItemName(itemRepo.getReferenceById(oderDTO.getOderDetailsDTOList().get(i).getItemEntity()).getItemName());
                        oderDetailsEntityList.get(i).setUnitDiscount(itemRepo.getReferenceById(oderDTO.getOderDetailsDTOList().get(i).getItemEntity()).getSupplyPrice() - itemRepo.getReferenceById(oderDTO.getOderDetailsDTOList().get(i).getItemEntity()).getSellPrice());
                        oderDetailsEntityList.get(i).setTotal(itemRepo.getReferenceById(oderDTO.getOderDetailsDTOList().get(i).getItemEntity()).getSellPrice() * oderDTO.getOderDetailsDTOList().get(i).getQty());
                        oderDetailsEntityList.get(i).setOderEntity(oderEntity);
                        oderDetailsEntityList.get(i).setItemEntity(itemRepo.getReferenceById(oderDTO.getOderDetailsDTOList().get(i).getItemEntity()));
                    }
                }
            double totalDiscount = 0;
            double netTotal = 0;
            for (int i = 0; i < oderDetailsEntityList.size(); i++) {
                totalDiscount += oderDetailsEntityList.get(i).getUnitDiscount();
                netTotal += oderDetailsEntityList.get(i).getTotal();
            }
            oderRepo.getReferenceById(oderEntity.getOderId()).setTotalDiscount(totalDiscount);
            oderRepo.getReferenceById(oderEntity.getOderId()).setNetTotal(netTotal);

            oderRepo.getReferenceById(oderEntity.getOderId()).setNoOfItem(oderDetailsEntityList.size());
            oderRepo.getReferenceById(oderEntity.getOderId()).setBalance(oderRepo.getReferenceById(oderEntity.getOderId()).getCash() - oderRepo.getReferenceById(oderEntity.getOderId()).getNetTotal());

                oderDetailsRepo.saveAll(oderDetailsEntityList);
                oderRepo.save(oderEntity);

        }
            return "saved";

        }
    */
    @Override
    public OderResponseDTO searchOder(int oderId) {

        if (oderRepo.existsByOderIdEqualsAndActiveStateEquals(oderId, true)) {

            List<OderDetailsEntity> oderDetailsEntityList = oderDetailsRepo.findAllByOderEntityEquals(oderRepo.getReferenceById(oderId)); //Collections.singleton(oderId)
            if (oderDetailsEntityList.size() > 0) {
                List<OderDetailsResponseDTO> oderDetailsResponseDTOList = new ArrayList<>();

                for (OderDetailsEntity oderDetailsEntity : oderDetailsEntityList) {

                    OderDetailsResponseDTO oderDetailsResponseDTO = new OderDetailsResponseDTO(
                            oderDetailsEntity.getDetailId(),
                            oderDetailsEntity.getItemName(),
                            oderDetailsEntity.getQty(),
                            oderDetailsEntity.getMeasuringType(),
                            oderDetailsEntity.getUnitDiscount(),
                            oderDetailsEntity.getTotal(),
                            oderId,
                            itemRepo.getReferenceById(oderId).getItemId() //error
                    );
                    oderDetailsResponseDTOList.add(oderDetailsResponseDTO);
                }

                OderEntity oderEntity = oderRepo.getReferenceById(oderId);
                OderResponseDTO oderResponseDTO = new OderResponseDTO(
                        oderEntity.getOderId(),
                        oderEntity.getCustomName(),
                        oderEntity.getDate(),
                        oderEntity.getNetTotal(),
                        oderEntity.getTotalDiscount(),
                        oderEntity.getCash(),
                        oderEntity.getBalance(),
                        oderEntity.getCashier(),
                        oderEntity.getNoOfItem(),
                        oderEntity.isActiveState(),
                        customRepo.getReferenceById(oderId).getCustomerId(),  //error
                        oderDetailsResponseDTOList,
                        employeeRepo.getReferenceById(oderId).getEmployeeId()  //error
                );
                return oderResponseDTO;

            } else {
                throw new NotFoundException("no list found (oderDetailsEntityList)");
            }

        } else {
            throw new NotFoundException("no id found (searchCustomer)");
        }

    }

    @Override
    public String cancelOder(int oderId) {

        if (oderRepo.existsById(oderId)) {
            OderEntity oderEntity = oderRepo.getReferenceById(oderId);

            if (oderEntity.isActiveState() == true) {
                boolean b = false;
                oderEntity.setActiveState(b);
                oderRepo.save(oderEntity);
                return oderId + " is canceld";

            } else {
                throw new RuntimeException("already canceld");
            }

        } else {
            throw new NotFoundException("no id found");
        }
    }

    @Override
    public List<OderOnlyResponseDTO> getOderByCustomer(int customerId) {

        List<OderEntity> oderEntityList = oderRepo.findAllByCustomEntityEquals(customRepo.getReferenceById(customerId));
        if (oderEntityList.size() > 0) {
            List<OderOnlyResponseDTO> oderOnlyResponseDTOList = new ArrayList<>();

            for (OderEntity oderEntity : oderEntityList) {

                OderOnlyResponseDTO oderOnlyResponseDTO = new OderOnlyResponseDTO(
                        oderEntity.getOderId(),
                        oderEntity.getCustomName(),
                        oderEntity.getDate(),
                        oderEntity.getNetTotal(),
                        oderEntity.getTotalDiscount(),
                        oderEntity.getCash(),
                        oderEntity.getBalance(),
                        oderEntity.getCashier(),
                        oderEntity.getNoOfItem(),
                        oderEntity.isActiveState(),
                        customerId,
                        employeeRepo.getReferenceById(oderEntity.getOderId()).getEmployeeId()   //error
                );
                oderOnlyResponseDTOList.add(oderOnlyResponseDTO);

            }
            return oderOnlyResponseDTOList;
        } else {
            throw new NotFoundException("no list found");
        }

    }

    @Override
    public List<OderDetailsResponseDTO> getOderDetailsByItem(int itemId) {

        List<OderDetailsEntity> oderDetailsEntityList = oderDetailsRepo.findAllByItemEntityEquals(itemRepo.getReferenceById(itemId));
        if (oderDetailsEntityList.size() > 0) {

            List<OderDetailsResponseDTO> oderDetailsResponseDTOList = new ArrayList<>();
            for (OderDetailsEntity oderDetailsEntity : oderDetailsEntityList) {

                OderDetailsResponseDTO oderDetailsResponseDTO = new OderDetailsResponseDTO(
                        oderDetailsEntity.getDetailId(),
                        oderDetailsEntity.getItemName(),
                        oderDetailsEntity.getQty(),
                        oderDetailsEntity.getMeasuringType(),
                        oderDetailsEntity.getUnitDiscount(),
                        oderDetailsEntity.getTotal(),
                        oderRepo.getReferenceById(itemId).getOderId(),  //error
                        itemId
                );
                oderDetailsResponseDTOList.add(oderDetailsResponseDTO);
            }
            return oderDetailsResponseDTOList;

        } else {

            throw new NotFoundException("no list found");
        }

    }


    @Override
    public List<OderOnlyResponseDTO> getoderBystate(boolean activeState) {

        List<OderEntity> oderEntityList = oderRepo.findAllByActiveStateEquals(activeState);
        if (oderEntityList.size() > 0) {

            List<OderOnlyResponseDTO> oderOnlyResponseDTOList = new ArrayList<>();
            for (OderEntity oderEntity : oderEntityList) {

                OderOnlyResponseDTO oderOnlyResponseDTO = new OderOnlyResponseDTO(
                        oderEntity.getOderId(),
                        oderEntity.getCustomName(),
                        oderEntity.getDate(),
                        oderEntity.getNetTotal(),
                        oderEntity.getTotalDiscount(),
                        oderEntity.getCash(),
                        oderEntity.getBalance(),
                        oderEntity.getCashier(),
                        oderEntity.getNoOfItem(),
                        oderEntity.isActiveState(),
                        itemRepo.getReferenceById(oderEntity.getOderId()).getItemId(),   //error,
                        employeeRepo.getReferenceById(oderEntity.getOderId()).getEmployeeId()   //error
                );
                oderOnlyResponseDTOList.add(oderOnlyResponseDTO);

            }

            return oderOnlyResponseDTOList;

        } else {

            throw new NotFoundException("no list found");
        }
    }


}


