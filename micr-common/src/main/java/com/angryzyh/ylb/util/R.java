package com.angryzyh.ylb.util;

import com.angryzyh.ylb.constant.REnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * R 封装 Controller返回结果集
 *
 * @author Angryzyh
 * @since 2022 -09-03 20:46:38
 */
@Getter
@AllArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 4974214711149403407L;

    private String code;

    private String msg;

    private T data;

    R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R() {
        this.code = REnum.OK.getCode();
        this.msg = REnum.OK.getMsg();
    }

    public static R ok() {
        return new R();
    }

    public static <T> R<T> ok(T data) {
        R r = ok();
        r.setData(data);
        return r;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static R error() {
        return error(REnum.UNKNOWN_ERROR.getCode(), REnum.UNKNOWN_ERROR.getMsg());
    }

    public static R error(String msg) {
        return error(REnum.UNKNOWN_ERROR.getCode(), msg);
    }

    public static R error(String code, String msg) {
        R r = new R(code, msg);
        return r;
    }
}