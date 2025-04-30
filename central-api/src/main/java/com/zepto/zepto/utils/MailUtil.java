package com.zepto.zepto.utils;

import com.zepto.zepto.requestDTO.RequestOrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MailUtil extends ApiUtilImpl{

    @Value("${mail.api.url}")
    String mailApiUrl;

    public void sendOrderNotification(RequestOrderDTO orderDTO) {
        String endPoint="/delhivery-partner/order/notify";
        Object resp=makePutCall(mailApiUrl,endPoint,new HashMap<>(), orderDTO);
    }
}
