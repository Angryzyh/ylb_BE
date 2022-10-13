package com.angryzyh.ylb.pojo.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品信息表
 *
 * @TableName b_product_info
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("b_product_info")
@ApiModel(value = "ProductInfoPo(产品信息表Po对象)")
public class ProductInfoPo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId("id")
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称",position = 1)
    private String productName;
    /**
     * 产品利率
     */
    @ApiModelProperty(value = "产品利率",position = 2)
    private BigDecimal rate;
    /**
     * 产品期限
     */
    @ApiModelProperty(value = "产品期限",position = 3)
    private Integer cycle;
    /**
     * 产品发布时间
     */
    @ApiModelProperty(value = "产品发布时间",position = 4)
    private Date releaseTime;
    /**
     * 产品类型 0新手宝，1优选产品，2散标产品
     */
    @ApiModelProperty(value = "产品类型(0新手宝,1优选产品,2散标产品)",position = 5)
    private Integer productType;
    /**
     * 产品编号
     */
    @ApiModelProperty(value = "产品编号",position = 6)
    private String productNo;
    /**
     * 产品金额
     */
    @ApiModelProperty(value = "产品金额",position = 7)
    private BigDecimal productMoney;
    /**
     * 产品剩余可投金额
     */
    @ApiModelProperty(value = "产品剩余可投金额",position = 8)
    private BigDecimal leftProductMoney;
    /**
     * 最低投资金额，即起投金额
     */
    @ApiModelProperty(value = "最低投资金额,即起投金额",position = 9)
    private BigDecimal bidMinLimit;
    /**
     * 最高投资金额，即最多能投多少金额
     */
    @ApiModelProperty(value = "最高投资金额,即最多能投多少金额",position = 10)
    private BigDecimal bidMaxLimit;
    /**
     * 产品状态（0未满标，1已满标，2满标已生成收益计划）
     */
    @ApiModelProperty(value = "产品状态(0未满标,1已满标,2满标已生成收益计划)",position = 11)
    private Integer productStatus;
    /**
     * 产品投资满标时间
     */
    @ApiModelProperty(value = "产品投资满标时间",position = 12)
    private Date productFullTime;
    /**
     * 产品描述
     */
    @ApiModelProperty(value = "产品描述",position = 13)
    private String productDesc;
}