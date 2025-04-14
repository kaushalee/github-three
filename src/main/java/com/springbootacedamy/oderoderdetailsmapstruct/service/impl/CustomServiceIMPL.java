package com.springbootacedamy.oderoderdetailsmapstruct.service.impl;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated.CustomPaginated;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.CustomDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.CustomDTOUpdate;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.CustomResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.CustomEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.exception.NotFoundException;
import com.springbootacedamy.oderoderdetailsmapstruct.repo.CustomRepo;
import com.springbootacedamy.oderoderdetailsmapstruct.service.CustomService;

import com.springbootacedamy.oderoderdetailsmapstruct.util.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomServiceIMPL implements CustomService {


    @Autowired
    private CustomRepo customRepo;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomDTO customDTO) {

        CustomEntity customEntity = customerMapper.customDTOTocustomEntity(customDTO);
        if (!customRepo.existsById(customEntity.getCustomerId())) {
            customRepo.save(customEntity);
            return customDTO.getCustomerName() + " is saved and your id is " + customEntity.getCustomerId();
        } else {
            throw new RuntimeException("already have (saveCustomer)");
        }
    }
/*
    @Override
    public String updateCustomer(CustomDTOUpdate customDTOUpdate) {

        if(customRepo.existsById(customDTOUpdate.getCustomerId())){

           CustomEntity customEntity= customRepo.getReferenceById(customDTOUpdate.getCustomerId());

           customEntity.setCustomerAddress(customDTOUpdate.getCustomerAddress());
           customEntity.setCusomerSalary(customDTOUpdate.getCusomerSalary());

           customRepo.save(customEntity);
            return customDTOUpdate.getCustomerId()  + "is updated and your id is " + customDTOUpdate.getCustomerId();
        }else {
            throw new RuntimeException("no id found (updateCustomer)");
        }


    }*/


    @Override
    public String updateCustomer(CustomDTOUpdate customDTOUpdate) {

        if (customRepo.existsById(customDTOUpdate.getCustomerId())) {

            CustomEntity customEntity = customRepo.getReferenceById(customDTOUpdate.getCustomerId());

            customEntity.setCustomerAddress(customDTOUpdate.getCustomerAddress());
            customEntity.setCusomerSalary(customDTOUpdate.getCusomerSalary());

            customRepo.save(customEntity);

            return customDTOUpdate.getCustomerId() + "is updated and your address is " + customDTOUpdate.getCustomerAddress() ;
        } else {
            throw new NotFoundException("no id found (updateCustomer)");
        }


    }

    @Override
    public CustomResponseDTO searchCustomer(int customerID) {

        if (customRepo.existsById(customerID)) {

            CustomEntity customEntity = customRepo.getReferenceById(customerID);
            CustomResponseDTO customResponseDTO = customerMapper.customEntityToCustomResponseDTO(customEntity);
            return customResponseDTO;
        } else {
            throw new NotFoundException("no id found (searchCustomer)");
        }
    }

    @Override
    public List<CustomResponseDTO> getAllCustomer() {

        List<CustomEntity> customEntityList = customRepo.findAll();

        if (customEntityList.size() > 0) {
            List<CustomResponseDTO> customResponseDTOList = customerMapper.customEntityListToCustomResponseDTOList(customEntityList);

            return customResponseDTOList;
        } else {
            throw new NotFoundException("no list found (getAllCustomer)");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {

        if (customRepo.existsById(customerId)) {

            customRepo.deleteById(customerId);
            return customerId + "is deleted";
        } else {
            throw new NotFoundException("no id found (deleteCustomer)");
        }
    }

    @Override
    public List<CustomResponseDTO> getAllCustomerByActiveState(boolean activeState) {

        List<CustomEntity> customEntityList = customRepo.findAllByActiveStateEquals(activeState);

        if (customEntityList.size() > 0) {
            List<CustomResponseDTO> customResponseDTOList = customerMapper.customEntityListToCustomResponseDTOList(customEntityList);

            return customResponseDTOList;
        } else {
            throw new NotFoundException("no list found (getAllCustomerByActiveState)");
        }
    }

    @Override
    public List<CustomResponseDTO> getAllCustomBySalaryAndState(double cusomerSalary) {

        boolean b = true;
        List<CustomEntity> customEntityList = customRepo.findAllByCusomerSalaryEqualsAndActiveStateEquals(cusomerSalary, b);

        if (customEntityList.size() > 0) {
            List<CustomResponseDTO> customResponseDTOList = customerMapper.customEntityListToCustomResponseDTOList(customEntityList);


            return customResponseDTOList;
        } else {
            throw new NotFoundException("no list found ( getAllCustomBySalaryAndState)");
        }
    }

    //pagination****************
    @Override
    public CustomPaginated getAllCustomerWithPageSize(int page, int size) {
        Page<CustomEntity> customEntityPage = customRepo.findAll(PageRequest.of(page, size));
        long datacount = customRepo.count();
        if (datacount <1) {
            throw new NotFoundException("no list found (getAllCustomerWithPageSize)");
        }else {

            return new CustomPaginated(
                    customerMapper.customEntityPageToCustomResponseDTOList(customEntityPage),
                    datacount
            );
        }
    }

    @Override
    public CustomPaginated getAllCustomerWithPage(int page) {




        return null;
    }










    @Override
    public CustomPaginated getAllCustomerWithoutPageSize() {
        return null;
    }

}


