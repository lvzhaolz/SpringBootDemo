package com.example.demo.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayUserAgreementPageSignResponse;
import com.example.demo.model.dto.AlipayDTO;

public class AlipayUtils {


    public static String payApp(AlipayDTO alipayDTO) {
        String result = null;

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayDTO.getServerUrl(), alipayDTO.getAppId(), alipayDTO.getPrivateKey(), alipayDTO.getFormat(),
                alipayDTO.getCharset(), alipayDTO.getPublicKey(), alipayDTO.getSignType());

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();

        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(alipayDTO.getBody());
        model.setSubject(alipayDTO.getSubject());
        model.setOutTradeNo(alipayDTO.getOutTradeNo());
        model.setTimeoutExpress(alipayDTO.getTimeoutExpress());
        model.setTotalAmount(alipayDTO.getTotalAmount());
        model.setProductCode(alipayDTO.getProductCode());

        request.setBizModel(model);
        request.setReturnUrl(alipayDTO.getReturnUrl());
        request.setNotifyUrl(alipayDTO.getNotifyUrl());

        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            //就是orderString 可以直接给客户端请求，无需再做处理。
            result = response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String payWeb(AlipayDTO alipayDTO) {
        String result = null;

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayDTO.getServerUrl(), alipayDTO.getAppId(), alipayDTO.getPrivateKey(), alipayDTO.getFormat(),
                alipayDTO.getCharset(), alipayDTO.getPublicKey(), alipayDTO.getSignType());

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradePayRequest request = new AlipayTradePayRequest();

        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradePayModel model = new AlipayTradePayModel();
//        model.setBody(alipayDTO.getBody());
        model.setSubject(alipayDTO.getSubject());
        model.setOutTradeNo(alipayDTO.getOutTradeNo());
        model.setTimeoutExpress(alipayDTO.getTimeoutExpress());
        model.setTotalAmount(alipayDTO.getTotalAmount());
//        model.setProductCode(alipayDTO.getProductCode());

        request.setBizModel(model);
//        request.setReturnUrl(alipayDTO.getReturnUrl());
//        request.setNotifyUrl(alipayDTO.getNotifyUrl());

        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradePayResponse response = alipayClient.pageExecute(request);

//            AlipayTradeAppPayResponse testResponse = alipayClient.sdkExecute(request);
//            if(testResponse.isSuccess()){
//                System.out.println("调用成功");
//            } else {
//                System.out.println("调用失败");
//            }

            //就是orderString 可以直接给客户端请求，无需再做处理。
            result = response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return result;
    }

}
