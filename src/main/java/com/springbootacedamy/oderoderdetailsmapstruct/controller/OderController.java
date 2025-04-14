package com.springbootacedamy.oderoderdetailsmapstruct.controller;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.OderDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderDetailsResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderOnlyResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.OderResponseDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.service.OderService;
import com.springbootacedamy.oderoderdetailsmapstruct.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/oder")
public class OderController {

    @Autowired
    private OderService oderService;

    @PostMapping("/save-oder")
    public ResponseEntity<StandedResponse> saveOder(@RequestBody OderDTO oderDTO) {

        String test = oderService.saveOder(oderDTO);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(200, "successs", test),
                HttpStatus.CREATED
        );
    }
/*
    @PostMapping("/save-oder-1")
    public ResponseEntity<StandedResponse> saveOderWithMapper(@RequestBody OderDTO oderDTO) {

        String test = oderService.saveOderWithMapper(oderDTO);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(200, "successs", test),
                HttpStatus.CREATED
        );
    }*/

    @GetMapping(path = "/get-oder-by-id", params = "id")  //request parem valin
    public ResponseEntity<StandedResponse> searchOder(@RequestParam(value = "id") int oderId) {

        OderResponseDTO oderResponseDTO = oderService.searchOder(oderId);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", oderResponseDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/cancel-oder", params = "id")  //request parem valin
    public ResponseEntity<StandedResponse> cancelOder(@RequestParam(value = "id") int oderId) {

        String text = oderService.cancelOder(oderId);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", text),
                HttpStatus.OK
        );

    }

        @GetMapping(path = "/get-oders-by-customer", params = "id")  //request parem valin
        public ResponseEntity<StandedResponse> getOderByCustomer ( @RequestParam(value = "id") int customerId){

            List<OderOnlyResponseDTO> oderOnlyResponseDTOList = oderService.getOderByCustomer(customerId);
            return new ResponseEntity<StandedResponse>(
                    new StandedResponse(201, "successs", oderOnlyResponseDTOList),
                    HttpStatus.OK
            );

        }

    @GetMapping(path = "/get-oders-details-by-item", params = "id")  //request parem valin
    public ResponseEntity<StandedResponse> getOderDetailsByItem ( @RequestParam(value = "id") int itemId){

        List<OderDetailsResponseDTO> oderDetailsResponseDTOList = oderService.getOderDetailsByItem(itemId);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", oderDetailsResponseDTOList),
                HttpStatus.OK
        );

    }

    @GetMapping(path = "/get- cancel-or-not-cancel-oder", params = "state")  //request parem valin
    public ResponseEntity<StandedResponse> getoderBystate( @RequestParam(value = "state") boolean activeState){

        List<OderOnlyResponseDTO> oderOnlyResponseDTOList = oderService.getoderBystate(activeState);
        return new ResponseEntity<StandedResponse>(
                new StandedResponse(201, "successs", oderOnlyResponseDTOList),
                HttpStatus.OK
        );

    }
    }
