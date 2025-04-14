package com.springbootacedamy.oderoderdetailsmapstruct.service.impl;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.EmployeeDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.entity.EmployeeEntity;
import com.springbootacedamy.oderoderdetailsmapstruct.repo.EmployeeRepo;
import com.springbootacedamy.oderoderdetailsmapstruct.service.EmployeeService;
import com.springbootacedamy.oderoderdetailsmapstruct.util.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo staffRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public String saveStaff(EmployeeDTO staffDTO) {

        EmployeeEntity employeeEntity = employeeMapper.staffDTOToEmployeeEntity(staffDTO);
        if (!staffRepo.existsById(employeeEntity.getEmployeeId())) {
            staffRepo.save(employeeEntity);
            return staffDTO.getEmployeeName() + " is saved and your id is " + employeeEntity.getEmployeeId();
        } else {
            throw new RuntimeException("already have (saveCustomer)");
        }
    }
}
