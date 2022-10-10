package com.angryzyh.ylb.util;

import com.angryzyh.ylb.constant.REnum;
import io.swagger.annotations.ApiModelProperty;

public class R<T>{
    @ApiModelProperty(value = "状态码",dataType = "String")
    private String code;
    @ApiModelProperty(value = "响应信息",dataType = "String")
    private String msg;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R() {
        this.code = REnum.OK.getCode();
        this.msg = REnum.OK.getMsg();
    }

    public R(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return new R<T>();
    }

    public static <T> R<T> ok(T data) {
        R<T> r = ok();
        r.setData(data);
        return r;
    }

    public static R error() {
        return error(REnum.UNKNOWN_ERROR.getCode(), REnum.UNKNOWN_ERROR.getMsg());
    }

    public static R error(String msg) {
        return error(REnum.UNKNOWN_ERROR.getCode(), msg);
    }

    public static R error(String code, String msg) {
        R r = new R<>(code, msg);
        return r;
    }


    public void setData(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}