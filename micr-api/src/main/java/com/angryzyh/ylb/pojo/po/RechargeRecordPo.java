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
 * 充值记录表
 * @TableName b_recharge_record
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("b_recharge_record")
public class RechargeRecordPo implements Serializable {
    /**
     * 
     */
    @TableId("id")
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 充值订单号
     */
    private String rechargeNo;

    /**
     * 充值订单状态（0充值中，1充值成功，2充值失败）
     */
    private Integer rechargeStatus;

    /**
     * 充值金额
     */
    private BigDecimal rechargeMoney;

    /**
     * 充值时间
     */
    private Date rechargeTime;

    /**
     * 充值描述
     */
    private String rechargeDesc;

    /**
     * 
     */
    private String channel;

    private static final long serialVersionUID = 1L;
}