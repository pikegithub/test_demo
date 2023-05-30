package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PayReqDto implements Serializable {

    /**
     * 商户订单号
     */
    private String payId;

    /**
     * 微信支付传入1 支付宝支付传入2
     */
    @NotNull(message = "支付类型不能为空")
    private Integer type;

    @NotNull(message = "金额不能为空")
    private BigDecimal price;

    /**
     * 签名
     */
    private String sign;

    private String param;

    private Integer isHtml;

    private String notifyUrl;

    private String returnUrl;

}