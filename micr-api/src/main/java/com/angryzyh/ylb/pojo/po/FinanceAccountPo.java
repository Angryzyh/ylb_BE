package com.angryzyh.ylb.pojo.po;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户财务资金账户表
 * @TableName u_finance_account
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("u_finance_account")
public class FinanceAccountPo implements Serializable {
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
     * 用户可用资金
     */
    private BigDecimal availableMoney;

    private static final long serialVersionUID = 1L;
}