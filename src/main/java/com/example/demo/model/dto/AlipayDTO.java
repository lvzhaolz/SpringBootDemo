package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AlipayDTO {

    private String body;
    private String subject;
    private String outTradeNo;
    private String totalAmount;
    private String productCode;
    private String returnUrl;
    private String notifyUrl;

    private String serverUrl;
    private String appId;
    private String privateKey;
    private String publicKey;
    private String format;
    private String charset;
    private String signType;
    private String timeoutExpress;

}
