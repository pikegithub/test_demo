package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CallBackReqDto {
    private String payId;	            //商户订单号
    private String param;               //创建订单的时候传入的参数
    private Integer type;	            //微信支付为1 支付宝支付为2
    private BigDecimal price;	        //订单金额
    private BigDecimal reallyPrice;	    //实际需付金额
    private String sign;                //校验签名
    private Integer status;             // 0标识失败  1标识成功  2标识处理中
}
