package com.example.demo.service;

import com.example.demo.RespDto.ResponseDto;
import com.example.demo.dto.CallBackReqDto;
import com.example.demo.dto.PayReqDto;
import com.example.demo.dto.PayRespDto;

public interface PayService {

    /**
     * 支付
     * @param payReqDto
     * @return
     */
    ResponseDto<PayRespDto> pay(PayReqDto payReqDto);

    /**
     * 回调接口
     * @return
     */
    ResponseDto callBack(CallBackReqDto callBackReqDto);

}
