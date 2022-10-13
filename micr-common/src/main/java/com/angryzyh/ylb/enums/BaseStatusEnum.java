package com.angryzyh.ylb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseStatusEnum {
    //on 为存在  // off 为禁用
    ON(1), OFF(9999);
    private final Integer code;
}