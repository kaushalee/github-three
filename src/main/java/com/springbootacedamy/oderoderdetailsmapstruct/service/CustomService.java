package com.springbootacedamy.oderoderdetailsmapstruct.service;

import com.springbootacedamy.oderoderdetailsmapstruct.dto.Paginated.CustomPaginated;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.CustomDTO;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.request.CustomDTOUpdate;
import com.springbootacedamy.oderoderdetailsmapstruct.dto.response.CustomResponseDTO;

import java.util.List;

public interface CustomService {


    String saveCustomer(CustomDTO customDTO);

    String updateCustomer(CustomDTOUpdate customDTOUpdate);

    CustomResponseDTO searchCustomer(int customerID);

    List<CustomResponseDTO> getAllCustomer();

    String deleteCustomer(int customerId);

    List<CustomResponseDTO> getAllCustomerByActiveState(boolean activeState);

    List<CustomResponseDTO> getAllCustomBySalaryAndState(double cusomerSalary);

    CustomPaginated getAllCustomerWithPageSize(int page, int size);

    CustomPaginated getAllCustomerWithPage(int page);

    CustomPaginated getAllCustomerWithoutPageSize();
}
