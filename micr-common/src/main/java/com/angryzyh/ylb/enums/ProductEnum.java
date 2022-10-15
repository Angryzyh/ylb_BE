package com.angryzyh.ylb.enums;

import cn.hutool.core.convert.impl.EnumConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

public class ProductEnum {
    @Getter
    @AllArgsConstructor
    public enum Type{
        NOVICE_PRODUCT(0, "新手宝"),
        PREFERRED_PRODUCT(1, "优选产品"),
        SCATTERER_PRODUCT(2, "散标产品");
        private final Integer code;
        private final String name;

        public static Boolean checkProductTypeUtil(Integer typeCode) {
            return Objects.equals(typeCode, PREFERRED_PRODUCT.getCode()) || Objects.equals(typeCode, SCATTERER_PRODUCT.getCode());
        }
    }

    @Getter
    @AllArgsConstructor
    public enum Status{
        NOT_FULL_BID(0, "未满标"),
        FULL_BID(1, "已满标"),
        FULL_BID_GENERATED_REVENUE_PLAN(2, "满标已生成收益计划");
        private final Integer code;
        private final String description;
    }


}
