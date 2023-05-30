package com.example.demo.RespEnum;

/**
 * @Author  carl
 * @Description 通用响应编码枚举常量
 */
public enum RespEnum {
    MSG_SUCCESS(1,"成功"),
    MSG_FAILED(-1,"调用失败"),
    MSG_ERR(99,"参数异常");

    private Integer code;
    private String msg;

    RespEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }

    public String getMsg(){
        return msg;
    }

    public void getMsg(String msg){
        this.msg = msg;
    }

    public Object value() {
        return null;
    }
}
