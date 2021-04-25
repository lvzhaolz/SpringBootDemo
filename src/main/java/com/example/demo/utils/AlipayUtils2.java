//package com.example.demo.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.*;
//import com.alipay.api.response.*;
//import com.sunnada.gaia.asp.capacity.model.alipay.*;
//import org.apache.commons.lang3.StringUtils;
//
///* 支付宝常用类 */
//public class AlipayUtils2 {
//    public static String connect(AlipayBean alipayBean, AlipayLink alipaylink) throws AlipayApiException {
//
//        // 1、获得初始化的AlipayClient
//        AlipayClient alipayClient = new DefaultAlipayClient(alipaylink.getGatewayurl(), // 支付宝网关
//                alipaylink.getAppId(), // appid
//                alipaylink.getPrivateKey(), // 商户私钥
//                "json", alipaylink.getCharset(), // 字符编码格式
//                alipaylink.getPublicKey(), // 支付宝公钥
//                alipaylink.getSignType()// 签名方式
//        );
//        // 2、设置请求参数
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        alipayRequest.setReturnUrl(alipaylink.getReturnUrl()); // 页面跳转同步通知页面路径
//        alipayRequest.setNotifyUrl(alipaylink.getNotifyUrl());// 服务器异步通知页面路径
//
//        // 封装参数
//        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
//
//        // 请求支付宝进行付款
//        String result = alipayClient.pageExecute(alipayRequest).getBody();
//
//        // 返回付款信息
//        return result;
//
//    }
//
//    /**
//     * 支付-网页
//     *
//     * @param alipayWebPayVO
//     * @return
//     * @throws AlipayApiException
//     */
//    public static String payWeb(AlipayWebPayVO alipayWebPayVO) throws AlipayApiException {
//        //实例化客户端
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayWebPayVO.getUrl(), alipayWebPayVO.getAppId(),
//                alipayWebPayVO.getPrivateKey(), alipayWebPayVO.getFormat(), alipayWebPayVO.getCharset(),
//                alipayWebPayVO.getAlipayPublicKey(), alipayWebPayVO.getSignType());
//        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
//        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//        request.setBizModel(alipayWebPayVO.getModel());
//        // 页面跳转同步通知页面路径
//        if (!StringUtils.isEmpty(alipayWebPayVO.getReturnUrl())) {
//            request.setReturnUrl(alipayWebPayVO.getReturnUrl());
//        }
//        // 服务器异步通知页面路径
//        if (!StringUtils.isEmpty(alipayWebPayVO.getNotifyUrl())) {
//            request.setNotifyUrl(alipayWebPayVO.getNotifyUrl());
//        }
//
//        //这里和普通的接口调用不同，使用的是sdkExecute
//        AlipayTradePagePayResponse response;
//        response = alipayClient.pageExecute(request);
//        return response.getBody();
//    }
//
//    /**
//     * 支付-App
//     *
//     * @param alipayAppPayVO
//     * @return
//     * @throws AlipayApiException
//     */
//    public static String payApp(AlipayAppPayVO alipayAppPayVO) throws AlipayApiException {
//        //实例化客户端
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayAppPayVO.getUrl(), alipayAppPayVO.getAppId(),
//                alipayAppPayVO.getPrivateKey(), alipayAppPayVO.getFormat(), alipayAppPayVO.getCharset(),
//                alipayAppPayVO.getAlipayPublicKey(), alipayAppPayVO.getSignType());
//        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//        request.setBizModel(alipayAppPayVO.getModel());
//        // 页面跳转同步通知页面路径
//        if (!StringUtils.isEmpty(alipayAppPayVO.getReturnUrl())) {
//            request.setReturnUrl(alipayAppPayVO.getReturnUrl());
//        }
//        // 服务器异步通知页面路径
//        if (!StringUtils.isEmpty(alipayAppPayVO.getNotifyUrl())) {
//            request.setNotifyUrl(alipayAppPayVO.getNotifyUrl());
//        }
//
//        //这里和普通的接口调用不同，使用的是sdkExecute
//        AlipayTradeAppPayResponse response;
//        response = alipayClient.execute(request);
//        return response.getBody();
//    }
//
//    /**
//     * 查询订单详情
//     *
//     * @param alipayQueryOrderVO
//     * @return
//     * @throws AlipayApiException
//     */
//    public static String query(AlipayQueryOrderVO alipayQueryOrderVO) throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayQueryOrderVO.getUrl(), alipayQueryOrderVO.getAppId(),
//                alipayQueryOrderVO.getPrivateKey(), alipayQueryOrderVO.getFormat(), alipayQueryOrderVO.getCharset(),
//                alipayQueryOrderVO.getAlipayPublicKey(), alipayQueryOrderVO.getSignType());
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//        request.setBizModel(alipayQueryOrderVO.getModel());
//        AlipayTradeQueryResponse response = alipayClient.execute(request);
//        return response.getBody();
//    }
//
//    /**
//     * 退款
//     *
//     * @param alipayRefundVO
//     * @return
//     * @throws AlipayApiException
//     */
//    public static String refund(AlipayRefundVO alipayRefundVO) throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayRefundVO.getUrl(), alipayRefundVO.getAppId(),
//                alipayRefundVO.getPrivateKey(), alipayRefundVO.getFormat(), alipayRefundVO.getCharset(),
//                alipayRefundVO.getAlipayPublicKey());
//        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
//        request.setBizModel(alipayRefundVO.getModel());
//        AlipayTradeRefundResponse response = alipayClient.execute(request);
//        return response.getBody();
//    }
//
//    /**
//     * 关闭交易
//     * 官方文档电脑网站支付中提到，App支付中未见到
//     *
//     * @param alipayCloseVO
//     * @return
//     * @throws AlipayApiException
//     */
//    public static String close(AlipayCloseVO alipayCloseVO) throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayCloseVO.getUrl(), alipayCloseVO.getAppId(),
//                alipayCloseVO.getPrivateKey(), alipayCloseVO.getFormat(), alipayCloseVO.getCharset(),
//                alipayCloseVO.getAlipayPublicKey(), alipayCloseVO.getSignType());
//        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
//        request.setBizModel(alipayCloseVO.getModel());
//        AlipayTradeCloseResponse response = alipayClient.execute(request);
//        return response.getBody();
//    }
//
//    /**
//     * 撤销交易
//     * 官方文档App支付中提到，电脑网站支付中未见到
//     *
//     * @param alipayCancelVO
//     * @return
//     * @throws AlipayApiException
//     */
//    public static String cancel(AlipayCancelVO alipayCancelVO) throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayCancelVO.getUrl(), alipayCancelVO.getAppId(),
//                alipayCancelVO.getPrivateKey(), alipayCancelVO.getFormat(), alipayCancelVO.getCharset(),
//                alipayCancelVO.getAlipayPublicKey(), alipayCancelVO.getSignType());
//        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
//        request.setBizModel(alipayCancelVO.getModel());
//        AlipayTradeCancelResponse response = alipayClient.execute(request);
//        return response.getBody();
//    }
//
//    /**
//     * 查询账单下载地址
//     *
//     * @param alipayQueryBillDownloadUrlVO
//     * @return
//     * @throws AlipayApiException
//     */
//    public static String queryBillDownloadUrl(AlipayQueryBillDownloadUrlVO alipayQueryBillDownloadUrlVO) throws AlipayApiException {
//        AlipayClient alipayClient = new DefaultAlipayClient(alipayQueryBillDownloadUrlVO.getUrl(),
//                alipayQueryBillDownloadUrlVO.getAppId(), alipayQueryBillDownloadUrlVO.getPrivateKey(),
//                alipayQueryBillDownloadUrlVO.getFormat(), alipayQueryBillDownloadUrlVO.getCharset(),
//                alipayQueryBillDownloadUrlVO.getAlipayPublicKey(), alipayQueryBillDownloadUrlVO.getSignType());
//        AlipayDataDataserviceBillDownloadurlQueryRequest request =
//                new AlipayDataDataserviceBillDownloadurlQueryRequest(); //创建API对应的request类
//        request.setBizModel(alipayQueryBillDownloadUrlVO.getModel());
//        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
//        return response.getBody();
//    }
//
//    /**
//     */
////	public static String alipay(AlipayBean alipayBean,AlipayLink alipaylink) throws AlipayApiException {
////
////		// 1、获得初始化的AlipayClient
////		AlipayClient alipayClient = new DefaultAlipayClient(alipaylink.getGatewayurl(), // 支付宝网关
////				alipaylink.getAppId(), // appid
////				alipaylink.getPrivateKey(), // 商户私钥
////				"json", alipaylink.getCharset(), // 字符编码格式
////				alipaylink.getPublicKey(), // 支付宝公钥
////				alipaylink.getSignType()// 签名方式
////		);
////		// 2、设置请求参数
////		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
////		alipayRequest.setReturnUrl(alipaylink.getReturnUrl()); // 页面跳转同步通知页面路径
////		alipayRequest.setNotifyUrl(alipaylink.getNotifyUrl());// 服务器异步通知页面路径
//////		http://10.206.147.45:8080/order/alipayNotify
//////		http://10.206.147.13:8020/UserApplication/examples/electricalBusiness/zfbfh.html
////		// 封装参数
////		alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
////
////		// 请求支付宝进行付款
////		String result = alipayClient.pageExecute(alipayRequest).getBody();
////
////		// 返回付款信息
////		return result;
////
////	}
////
////	public static String tuikuan(Tuikuan alipayBean,AlipayLink alipaylink) throws AlipayApiException {
////
////		// 1、获得初始化的AlipayClient
////		AlipayClient alipayClient = new DefaultAlipayClient(alipaylink.getGatewayurl(), // 支付宝网关
////				alipaylink.getAppId(), // appid
////				alipaylink.getPrivateKey(), // 商户私钥
////				"json", alipaylink.getCharset(), // 字符编码格式
////				alipaylink.getPublicKey(), // 支付宝公钥
////				alipaylink.getSignType()// 签名方式
////		);
////		// 2、设置请求参数
////		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
////
////
////		// 封装参数
////		request.setBizContent(JSON.toJSONString(alipayBean));
////		//System.out.println(alipayBean.getRefund_amount());
////
////		// 请求支付宝进行付款
////		AlipayTradeRefundResponse response = alipayClient.execute(request);
////		Map<String, String> map = new HashMap<>();
////
////		if (response.isSuccess()) {
////			System.out.println("退款调用成功"+response.getBody());
////			String str=response.getMsg();
////			return str;
////		} else {
////			System.out.println("退款调用失败"+response.getBody());
////			return "失败";
////		}
////		// 返回付款信息
////
////	}
////
////	public static Quest query(QueryBean query,AlipayLink alipaylink) throws AlipayApiException {
////		AlipayClient alipayClient = new DefaultAlipayClient(alipaylink.getGatewayurl(), // 支付宝网关
////				alipaylink.getAppId(), // appid
////				alipaylink.getPrivateKey(), // 商户私钥
////				"json", alipaylink.getCharset(), // 字符编码格式
////				alipaylink.getPublicKey(), // 支付宝公钥
////				alipaylink.getSignType()// 签名方式);
////				);
////		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
////		request.setBizContent(JSON.toJSONString(query));
////		// request.setBizContent("{" +
////		// "\"out_trade_no\":\"sda12\"" +
////		// " }");
////		Quest quest=new Quest();
////		AlipayTradeQueryResponse response = alipayClient.execute(request);
////		if (response.isSuccess()) {
//////			System.out.println("支付查询调用成功");
//////			System.out.println(response.getBody());
////			quest.setState("调用成功");
////		} else {
//////			System.out.println("支付查询调用失败");
//////			System.out.println(response.getBody());
////			quest.setState("调用失败");
////		}
////
////
////		quest.setOutTradeNo(response.getOutTradeNo());
////		quest.setTotalAmount(response.getTotalAmount());
////		quest.setTradeNo(response.getTradeNo());
////		quest.setTradeStatus(response.getTradeStatus());
////		return quest;
////	}
////
////	public static Quest tuiKuanQuery(String out_request_no,String out_trade_no) throws AlipayApiException {
////		AlipayClient alipayClient = new DefaultAlipayClient(PropertiesConfig.getKey("gatewayUrl"),
////				PropertiesConfig.getKey("app_id"), PropertiesConfig.getKey("merchant_private_key"), "json", "UTF-8",
////				PropertiesConfig.getKey("alipay_public_key"), "RSA2");
////
////		AlipayTradeFastpayRefundQueryModel model = new AlipayTradeFastpayRefundQueryModel();
////		model.setOutRequestNo(out_request_no);
////		model.setOutTradeNo(out_trade_no);
////		// model.setTradeNo("20150320010101001");
////
////		AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
////		request.setBizModel(model);
////
////		AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
////		Quest quest=new Quest();
////		if (response.isSuccess()) {
////			System.out.println("退款查询调用成功");
////			quest.setState("调用成功");
////		} else {
////			System.out.println("退款查询调用失败");
////			quest.setState("调用失败");
////		}
////		System.out.println(response.getBody());
////		quest.setOutTradeNo(response.getOutTradeNo());
////		quest.setTotalAmount(response.getRefundAmount());
////		quest.setTradeNo(response.getOutRequestNo());
////		quest.setTradeStatus("退款成功");
////
////		return quest;
////	}
////
////	// 平台转给商家
////	public Object payment(Payment payment,AlipayLink alipaylink) {
////		AlipayClient alipayClient = new DefaultAlipayClient(alipaylink.getGatewayurl(), // 支付宝网关
////				alipaylink.getAppId(), // appid
////				alipaylink.getPrivateKey(), // 商户私钥
////				"json", alipaylink.getCharset(), // 字符编码格式
////				alipaylink.getPublicKey(), // 支付宝公钥
////				alipaylink.getSignType()// 签名方式
////				);
////		AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
////		request.setBizContent(JSON.toJSONString(payment));
////		System.out.println("out_biz_no"+payment.getOut_biz_no());
//////		request.setBizContent("{" +
//////		"    \"out_biz_no\":\"123572365\"," +
//////		"    \"payee_type\":\"ALIPAY_LOGONID\"," +
//////		"    \"payee_account\":\"cpdgct0750@sandbox.com\"," +
//////		"    \"amount\":\"12.23\"," +
//////		"  }");
////
////		AlipayFundTransToaccountTransferResponse response = null;
////
////			try {
////				response = alipayClient.execute(request);
////			} catch (AlipayApiException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		Quest quest=new Quest();
////		if (response.isSuccess()) {
////			System.out.println("转账调用成功");
////			quest.setState(response.getMsg());
////			quest.setOutTradeNo(response.getOutBizNo());
////			quest.setTotalAmount(response.getOrderId());
////			quest.setTradeNo(response.getPayDate());
////		} else {
////			System.out.println("转账调用失败");
////			quest.setState(response.getMsg());
////			quest.setOutTradeNo(payment.getOut_biz_no());;
////		}
////
////		return quest;
////
////	}
/////*
//// * app支付
//// */
////	public static String apppay(AlipayLink alipaylink,AlipayBean alipayBean) {
////		AlipayClient alipayClient = new DefaultAlipayClient(alipaylink.getGatewayurl(), // 支付宝网关
////				alipaylink.getAppId(), // appid
////				alipaylink.getPrivateKey(), // 商户私钥
////				"json", alipaylink.getCharset(), // 字符编码格式
////				alipaylink.getPublicKey(), // 支付宝公钥
////				alipaylink.getSignType()// 签名方式
////				);
////
////		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
////		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
////		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
////		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//////		model.setBody("我是测试数据");
//////		model.setSubject("App支付测试Java");
//////		model.setOutTradeNo(str);
//////		model.setTimeoutExpress("30m");
//////		model.setTotalAmount("0.01");
//////		model.setProductCode("QUICK_MSECURITY_PAY");
////		model.setBody(alipayBean.getBody());
////		model.setSubject(alipayBean.getSubject());
////		model.setOutTradeNo(alipayBean.getOut_trade_no());
////		model.setTimeoutExpress("90m");
////		model.setTotalAmount(alipayBean.getTotal_amount());
////		model.setProductCode("QUICK_MSECURITY_PAY");
////		request.setBizModel(model);
////		request.setNotifyUrl(alipaylink.getNotifyUrl());
//////		EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
////		AlipayTradeAppPayResponse response=null;
////		try {
////			// 这里和普通的接口调用不同，使用的是sdkExecute
////			response = alipayClient.sdkExecute(request);
////			System.out.println(response.getBody());// 就是orderString
////											// 可以直接给客户端请求，无需再做处理。
////		} catch (AlipayApiException e) {
////			e.printStackTrace();
////		}
////		return response.getBody();
////	}
////
////
////	public static void sss(){
////		AlipayClient alipayClient = new DefaultAlipayClient(PropertiesConfig.getKey("gatewayUrl"),
////				PropertiesConfig.getKey("app_id"), PropertiesConfig.getKey("merchant_private_key"), "json", "UTF-8",
////				PropertiesConfig.getKey("alipay_public_key"), "RSA2");
////		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();//创建API对应的request类
////		request.setBizContent("{" +
////		"   \"out_trade_no\":\"1111111111\"," +
////		"  }");//设置业务参数
////		AlipayTradeQueryResponse response = null;
////		try {
////			response = alipayClient.execute(request);
////		} catch (AlipayApiException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}//通过alipayClient调用API，获得对应的response类
////		System.out.print(response.getBody());
////	}
////
//
//}
