package com.zepto.zepto.requestDTO;

import com.zepto.zepto.models.AppUser;
import com.zepto.zepto.responsedto.ResponseBillDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderDTO {
    AppUser customer;
    AppUser delhiveryPartner;
    ResponseBillDTO bill;
}
