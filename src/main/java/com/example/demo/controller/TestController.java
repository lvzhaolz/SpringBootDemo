package com.example.demo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePayRequest;
import com.example.demo.config.AlipayConfig;
import com.example.demo.model.BaseResponseBean;
import com.example.demo.model.dto.AlipayDTO;
import com.example.demo.utils.AlipayUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther lvzhao
 * Created on 2020/12/18.
 */
@RestController
@RequestMapping
@Slf4j
public class TestController {

    @Autowired
    private AlipayConfig alipayConfig;

    @GetMapping("/test")
    public BaseResponseBean<String> test(HttpServletRequest request, HttpServletResponse response) {
        return new BaseResponseBean<>("0", "sss", "message");
    }

    @GetMapping("/test2")
    public BaseResponseBean<String> test2(HttpServletRequest request, HttpServletResponse response) {
        return new BaseResponseBean<>("1", "sss", "message");
    }

    @GetMapping("/alipay")
    public void alipay(HttpServletResponse response) {
        AlipayDTO alipayDTO = new AlipayDTO();
        alipayDTO.setServerUrl(alipayConfig.getServerUrl())
                .setAppId(alipayConfig.getAppId())
                .setPrivateKey(alipayConfig.getPrivateKey())
                .setPublicKey(alipayConfig.getPublicKey())
                .setFormat(alipayConfig.getFormat())
                .setCharset(alipayConfig.getCharset())
                .setSignType(alipayConfig.getSignType())
                .setTimeoutExpress(alipayConfig.getTimeoutExpress());

        alipayDTO.setBody("")
                .setSubject("Iphone6 16G")
                .setOutTradeNo(System.currentTimeMillis()+"")
                .setTotalAmount("0.01")
                .setProductCode("001");

//        String resutl = "<html><body>" +
//                AlipayUtils.payWeb(alipayDTO) +
//                "</body></html>";
//        log.info(resutl);
//        return resutl;


        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(AlipayUtils.payWeb(alipayDTO));
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }




////        AlipayClient alipayClient = new
////                DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",
////                "2021000117631989",
////                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCdNvZWVtSjoEKpBZCWxiqpA8zMcZr6vzu7V60QnLc0P0pW8sG2cGT+MBHTNoklz0dewSr1eAmZ4lf7qvRml+twg8INgMD/CmlX7iic8/dfXqZyvbnKNvz/57U5j7XJAqL++L0MbMhSVUrcNEl7ztK+25cU4oxVry9UOKfIOtAVVU8fbLNdwKaJABXw4sfgzq3Dk4Nk34DGVC4Vt18bm00usp6zSph65miefDTD+5mcxCvpOf9iGQz59slI0i0fB+yi01KtxNLXrbvMcAyT56VZ5ACifELg4PnYJ+725P5slT3V3sQWLHVNcF8hTpbNBzlImQ6aEvtkFlzgQFEIaDjnAgMBAAECggEAB+qQlOBibKrRMHmbQjxQQZpzYYgG6cFfXJuZl1CM2RCmyaIHpwwZycLZ4uzIEyNQ0LChXSLiOOFw1LdS/yd/L3cy+kMVdMItc8QGP4D5X9AASZ7MECacrrYYJgHagXikhHo56ro/jAXHczcezCEp83pTLTYLIvVjSLZhnG95stk4n6rJBGnsN4XDKoGvWS888Jn4A5d91tB0dza/+/zMnJBVaUG+I8J7t6sxBLHkt44nrhWBeoA/4LPwAb6Ku7kCJjpJFj+wMb65zB03cvpsJSxGtc/g6YHNeezxZZUfuUHBHD/qZD8RJbVzHeg14btCb8j6OgnnLJVLQM+2eJHlQQKBgQDPdd609OOLx6rV6V7E+VayU/+5GO34FYlsJjZsz7h7+wkrjlM/jynpCkgm9akawWe2ZLSBYsa4rSB4DDrrY/kYaD0rpuVf/C+IbZGkbLKxZtQjIzWiOU3ZrX3DO8aopY/Xax/kTyC7IEoY2nSyjfLqTE2BDuqp6SxCm0+89hrKGQKBgQDB/43w0YSehZntxzeIbBPmWQKFSc9KJAv6IEg5JLoe+2x6KHH2v5/9tI86zwb7fH72Rl5tjP77yjbEOogDzgGmrG8bgRJ1ifeQjS4wSJMK8XpO5/Ud6NaKT7aisP5FxGyMHlTbHEQYI1QipE32F+SCQngUmgq+0wET5mCnSdF6/wKBgQC8dseqfA16nhiD201Mg3ZO6iAVdqA4DtiYdt5aWxmtB5B9EP5vbw8TtVN2kRTeSXR+LV4NbD465ovogrPDwz42/fsT/LnDSMWlmmQEivqKTm/Iu+OtS4F9ji4BffwqmLzjZV3Del6xn9OwYERDMNDMKCUAaRyk3j5nA9CcSLZtgQKBgQC/xO967qI6Ubcn5ZZvtOa2/aYQPDY9BAUS7HZ4hmW12rQQzYpacHKnSKWNbLlqQFcA++68PHSSUgJxV6q8mBfpuuraNW0Z45hlvCm8cQFp/+r3tTQIrPHnJ4VSrcOtE855dEJNllN5yPKSi/jFHDk2yp4JP3z/xXV7RnCk7cO14QKBgAEHXu1eT0InnLUAtprFv7fesbkUar1x9Vl3R2nvz33JrtVFoN7z3VuIg1ZuL4Xrfhizxqx6n9L+4LG9gDKhGWonSDe7GogVmT5+vYoWEaBEYPfSKQb2GmILHhGY6+S0ygyPzd9Z2LR3y/Op20FHqjNrzFJL/MFuE3eLV90w4cqd",
////                "json", "utf-8",
////                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiRduAVo8Cr/CCH58j3x4RHZ94tgX4frkPr78cOruIFzET0osqyl/o9wGiD7ZEC8d9+HT73jRTcFc/jmDkk9edo7yUMoqmC5WmaAkEd/tJhTydVANBrUNay2pFgzjv4unV3fRje0POxIBiijFELcGZo+u7WVSWhdXUXcJYHsbqtG2uqGP0rY1Xshxu/n0wb496pBD4hRkeT/56LbttpvRGCwXXir0Hbmjx5Pxxem6PlAoP5lHQ4+T7EiS4/cM4Bxc+ByyIFTar2Ka8b00YdILViRvQHTgWQI/xEzQDVPAzTjYO38Sayz76GWzbqaCuag/NR0zcNzSwGTopng0AdkNCQIDAQAB",
////                "RSA2");
//
//        //实例化客户端
//        AlipayClient alipayClient = new DefaultAlipayClient(
//                alipayConfig.getServerUrl(), alipayConfig.getAppId(), alipayConfig.getPrivateKey(), alipayConfig.getFormat(),
//                alipayConfig.getCharset(), alipayConfig.getPublicKey(), alipayConfig.getSignType());
//
//        AlipayTradePayRequest request = new AlipayTradePayRequest();
//        AlipayTradePayModel model = new AlipayTradePayModel();
//        request.setBizModel(model);
//
//        model.setOutTradeNo(System.currentTimeMillis() + "");
//        model.setSubject("Iphone6 16G");
//        model.setTotalAmount("0.01");
////        model.setAuthCode("xxxxx");//沙箱钱包中的付款码
////        model.setScene("bar_code");
//
//        try {
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().write(alipayClient.pageExecute(request).getBody());
//            response.getWriter().flush();
//            response.getWriter().close();
//        } catch (AlipayApiException | IOException e) {
//            e.printStackTrace();
//        }


    }

}
