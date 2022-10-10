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
 * 收益记录表
 * @TableName b_income_record
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("b_income_record")
public class IncomeRecordPo implements Serializable {
    /**
     *
     */
    @TableId("id")
    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 产品ID
     */
    private Integer prodId;

    /**
     * 投标记录ID
     */
    private Integer bidId;

    /**
     * 投资金额
     */
    private BigDecimal bidMoney;

    /**
     * 期到时间
     */
    private Date incomeDate;

    /**
     * 收益金额
     */
    private BigDecimal incomeMoney;

    /**
     * 收益状态（0未返，1已返）
     */
    private Integer incomeStatus;

    private static final long serialVersionUID = 1L;
}