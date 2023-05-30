package com.example.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.RespDto.ResponseDto;
import com.example.demo.RespEnum.RespEnum;
import com.example.demo.constant.PayConstants;
import com.example.demo.dto.CallBackReqDto;
import com.example.demo.dto.PayReqDto;
import com.example.demo.dto.PayRespDto;
import com.example.demo.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PayServiceImpl implements PayService {

    /**
     * 支付
     * @param payReqDto
     * @return
     */
    @Override
    public ResponseDto<PayRespDto> pay(PayReqDto payReqDto) {
        //生成签名 商户订单号
        String payId = String.valueOf(DateUtil.current());
        String signStr = ObjectUtil.isEmpty(payReqDto.getParam())
                ? payId + payReqDto.getType() + payReqDto.getPrice() + PayConstants.PAY_SECRET_KEY
                : payId + payReqDto.getParam() + payReqDto.getType() + payReqDto.getPrice() + PayConstants.PAY_SECRET_KEY;

        payReqDto.setSign(DigestUtil.md5Hex(signStr));
        payReqDto.setPayId(payId);

        // 请求创建订单接口
        Map<String, String > heads = new HashMap<>();
        heads.put("Content-Type", "application/json;charset=UTF-8");
        HttpResponse response = HttpRequest.post(PayConstants.PAY_CREATE_ORDER_URL)
                .headerMap(heads, false)
                .body(JSONObject.toJSONString(payReqDto))
                .timeout(5 * 60 * 1000)
                .execute();

        PayRespDto payRespDto = null;
        String body = response.body();
        if (ObjectUtil.isNotEmpty(body)){
            Map result = JSON.parseObject(body,Map.class);
            String dataStr =result.get("data").toString();
            if (ObjectUtil.isNotEmpty(dataStr)){
                payRespDto = JSONObject.parseObject(dataStr, PayRespDto.class);
            }
        }
        return new ResponseDto<>(RespEnum.MSG_SUCCESS.getCode(), RespEnum.MSG_SUCCESS.getMsg(),payRespDto);
    }

    /**
     * 回调接口
     * @return
     */
    @Override
    public ResponseDto callBack(CallBackReqDto callBackReqDto) {
        //校验签名
        String sign = DigestUtil.md5Hex(callBackReqDto.getPayId() + callBackReqDto.getParam() + callBackReqDto.getType()
                + callBackReqDto.getPrice() + callBackReqDto.getReallyPrice() + PayConstants.PAY_SECRET_KEY);
        if (!callBackReqDto.getSign().equals(sign)){
            return new ResponseDto<>(RespEnum.MSG_ERR.getCode(), RespEnum.MSG_ERR.getMsg(),"校验签名失败");
        }

        Integer status = callBackReqDto.getStatus();
        //后续业务处理...
        return new ResponseDto<>(RespEnum.MSG_SUCCESS.getCode(), RespEnum.MSG_SUCCESS.getMsg());
    }

}
