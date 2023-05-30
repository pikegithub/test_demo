package com.example.demo.RespDto;

import com.example.demo.RespEnum.RespEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDto<T> implements Serializable {
    /**
     * 	返回代码（1：成功，-1：调用失败）
     */
    private Integer code;
    /**
     * api调用结果说明
     */
    private String msg;
    /**
     * 响应体
     */
    private T data;

    public ResponseDto() {

    }

    public ResponseDto(T respData) {
        this(RespEnum.MSG_SUCCESS.getCode(),RespEnum.MSG_SUCCESS.getMsg(),respData);
    }

    public ResponseDto(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseDto(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseDto(RespEnum respEnum, T data) {
        this.code = respEnum.getCode();
        this.msg = respEnum.getMsg();
        this.data = data;
    }

}
