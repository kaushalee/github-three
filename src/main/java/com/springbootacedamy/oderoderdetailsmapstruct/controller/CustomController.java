package com.springbootacedamy.oderoderdetailsmapstruct.controller;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated.CustomPaginated;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.CustomDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.CustomDTOUpdate;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.CustomResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.service.CustomService;
import com.springbootacedamy.oderoderdetailsmapstruct.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")

//post-200,204
//put-201,204
//get,delete-201  /  error -404(not found)
//200-created
//201-ok
//204-no contex
public class CustomController {

    @Autowired
    private CustomService customService;

    @PostMapping("/save-customer")
    public ResponseEntity<StandedResponse> saveCustomer(@RequestBody CustomDTO customDTO) {

        String test = customService.saveCustomer(customDTO);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(200, "successs all", test),
                HttpStatus.CREATED
        );

    }

    @PutMapping("/update-customer")
    public ResponseEntity<StandedResponse> updateCustomer(@RequestBody CustomDTOUpdate customDTOUpdate) {

        String test = customService.updateCustomer(customDTOUpdate);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", test),
                HttpStatus.OK
        );

    }

    @GetMapping(path = "/get-customer-by-id", params = "id")  //request parem valin
    public ResponseEntity<StandedResponse> searchCustomer(@RequestParam(value = "id") int customerID) {

        CustomResponseDTO customResponseDTO = customService.searchCustomer(customerID);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", customResponseDTO),
                HttpStatus.OK
        );
    }

    @GetMapping("get-all-customer")
    public ResponseEntity<StandedResponse> getAllCustomer() {

        List<CustomResponseDTO> customResponseDTOList = customService.getAllCustomer();
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", customResponseDTOList),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "get-all-customer-with-page-size", params = {"page", "size"})
    public ResponseEntity<StandedResponse> getAllCustomerWthPageSize(@RequestParam(value = "page") int page,
                                                                     @RequestParam(value = "size") int size) {

       CustomPaginated customPaginated = customService.getAllCustomerWithPageSize(page,size);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", customPaginated),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "get-all-customer-with-page",params = "page")
    public ResponseEntity<StandedResponse> getAllCustomerWithPage(@RequestParam(value = "page") int page) {


        CustomPaginated customPaginated = customService.getAllCustomerWithPage(page);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", customPaginated),
                HttpStatus.OK
        );
    }

    @GetMapping("get-all-customer-without-page-size")
    public ResponseEntity<StandedResponse> getAllCustomerWithoutPageSIze() {


        CustomPaginated customPaginated = customService.getAllCustomerWithoutPageSize();
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", customPaginated),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-customer", params = "id")    //path variable valin
    public ResponseEntity<StandedResponse> deleteCustomer(@RequestParam(value = "id") int customerId) {

        String text = customService.deleteCustomer(customerId);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", text),
                HttpStatus.OK
        );
    }

    /*
        @DeleteMapping( "/delete-customer/{id}")    //path variable valin
      public String deleteCustomer(@PathVariable(value = "id") int customerId ){

          String text=customService.deleteCustomer(customerId);
          return text;
      }*/
    @GetMapping(path = "/get-all-customer-by-active-state", params = "activeState")
    public ResponseEntity<StandedResponse> getAllCUstomerByActiveState(@RequestParam(value = "activeState") boolean activeState) {


        List<CustomResponseDTO> customResponseDTOList = customService.getAllCustomerByActiveState(activeState);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", customResponseDTOList),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/get-all-Custom -by-name-and-state", params = "salary")
    public ResponseEntity<StandedResponse> getAllCustomBySalaryAndState(@RequestParam(value = "salary") double cusomerSalary) {

        List<CustomResponseDTO> customResponseDTOList = customService.getAllCustomBySalaryAndState(cusomerSalary);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", customResponseDTOList),
                HttpStatus.OK
        );
    }

}
