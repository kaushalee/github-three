package com.springbootacedamy.oderoderdetailsmapstruct.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandedResponse {


    int code;
    String message;
    Object response;
}
