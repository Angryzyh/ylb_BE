package com.angryzyh.ylb.pojo.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品信息表
 * @TableName b_product_info
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("b_product_info")
public class ProductInfoPo implements Serializable {

    /**
     * 
     */
    @TableId("id")
    private Integer id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品利率
     */
    private BigDecimal rate;

    /**
     * 产品期限
     */
    private Integer cycle;

    /**
     * 产品发布时间
     */
    private Date releaseTime;

    /**
     * 产品类型 0新手宝，1优选产品，2散标产品
     */
    private Integer productType;

    /**
     * 产品编号
     */
    private String productNo;

    /**
     * 产品金额
     */
    private BigDecimal productMoney;

    /**
     * 产品剩余可投金额
     */
    private BigDecimal leftProductMoney;

    /**
     * 最低投资金额，即起投金额
     */
    private BigDecimal bidMinLimit;

    /**
     * 最高投资金额，即最多能投多少金额
     */
    private BigDecimal bidMaxLimit;

    /**
     * 产品状态（0未满标，1已满标，2满标已生成收益计划）
     */
    private Integer productStatus;

    /**
     * 产品投资满标时间
     */
    private Date productFullTime;

    /**
     * 产品描述
     */
    private String productDesc;

    private static final long serialVersionUID = 1L;
}