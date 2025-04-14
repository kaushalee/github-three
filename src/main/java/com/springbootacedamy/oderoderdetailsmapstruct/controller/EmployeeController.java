package com.springbootacedamy.oderoderdetailsmapstruct.controller;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.EmployeeDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.service.EmployeeService;
import com.springbootacedamy.oderoderdetailsmapstruct.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService staffService;

    @PostMapping("/save-employee")
    public ResponseEntity<StandedResponse> saveStaff(@RequestBody EmployeeDTO staffDTO ) {

        String test = staffService.saveStaff(staffDTO);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(200, "successs", test),
                HttpStatus.CREATED
        );

    }


}
