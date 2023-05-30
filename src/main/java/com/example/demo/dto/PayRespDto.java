package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PayRespDto implements Serializable {
    private String payId;	            //商户订单号
    private String orderId;             //云端订单号，可用于查询订单是否支付成功
    private Integer payType;	        //微信支付为1 支付宝支付为2
    private BigDecimal price;	        //订单金额
    private BigDecimal reallyPrice;	    //小数	实际需付金额
    private String payUrl;	            //字符串	支付二维码内容
    private Integer isAuto;	            //整数	1需要手动输入金额 0扫码后自动输入金额
    private Integer state;	            //整数	订单状态：-1|订单过期 0|等待支付 1|完成 2|支付完成但通知失败
    private Integer timeOut;	        //整数	订单有效时间（分钟）
    private Long date;	                //长整数	订单创建时间时间戳（10位）
}
