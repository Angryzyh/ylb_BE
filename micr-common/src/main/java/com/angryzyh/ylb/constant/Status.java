package com.angryzyh.ylb.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    //on 为存在  // off 为禁用
    ON(1), OFF(9999);
    private Integer code;
}