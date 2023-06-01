package com.example.demo.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.demo.RespDto.ResponseDto;
import com.example.demo.RespEnum.RespEnum;
import com.example.demo.mapper.AuthRoleMapper;
import com.example.demo.domain.AuthRole;
import com.example.demo.dto.CallBackReqDto;
import com.example.demo.dto.PayReqDto;
import com.example.demo.dto.PayRespDto;
import com.example.demo.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/testDemo")
public class PayController {
    @Autowired
    private PayService payService;

    @Autowired
    private AuthRoleMapper authRoleMapper;

    /**
     * 支付接口
     */
    @PostMapping("/pay")
    public ResponseDto<PayRespDto> pay(@Validated @RequestBody PayReqDto payReqDto) {
        if (BeanUtil.isEmpty(payReqDto)){
            return new ResponseDto<>(RespEnum.MSG_ERR.getCode(), RespEnum.MSG_ERR.getMsg());
        }
        log.info("/pay请求参数:{}", payReqDto);
        return payService.pay(payReqDto);
    }

    /**
     * 回调接口
     */
    @PostMapping("/callBack")
    public ResponseDto callBack(@RequestBody CallBackReqDto callBackReqDto) {
        if (BeanUtil.isEmpty(callBackReqDto)){
            return new ResponseDto<>(RespEnum.MSG_ERR.getCode(), RespEnum.MSG_ERR.getMsg());
        }
        log.info("/callBack请求参数:{}", callBackReqDto);
        return payService.callBack(callBackReqDto);
    }

    /**
     * test
     */
    @PostMapping("/test")
    public ResponseDto test() {
        List<AuthRole> authRoles = authRoleMapper.selectAll();
        return new ResponseDto<>(RespEnum.MSG_SUCCESS.getCode(), RespEnum.MSG_SUCCESS.getMsg(),authRoles);
    }
}
