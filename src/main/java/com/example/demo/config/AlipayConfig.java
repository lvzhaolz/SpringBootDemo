package com.example.demo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AlipayConfig {

    @Value("${alipay.pay.server-url}")
    private String serverUrl;
    @Value("${alipay.pay.app-id}")
    private String appId;
    @Value("${alipay.pay.private-key}")
    private String privateKey;
    @Value("${alipay.pay.public-key}")
    private String publicKey;
    @Value("${alipay.pay.format}")
    private String format;
    @Value("${alipay.pay.charset}")
    private String charset;
    @Value("${alipay.pay.sign-type}")
    private String signType;
    @Value("${alipay.pay.timeout-express}")
    private String timeoutExpress;

}
