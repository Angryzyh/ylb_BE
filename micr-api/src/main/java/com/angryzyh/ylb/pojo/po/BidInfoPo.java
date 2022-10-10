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
 * 投资记录表
 * @TableName b_bid_info
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("b_bid_info")
public class BidInfoPo implements Serializable {
    /**
     * 投标记录ID
     */
    @TableId("id")
    private Integer id;

    /**
     * 产品ID
     */
    private Integer prodId;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 投标金额
     */
    private BigDecimal bidMoney;

    /**
     * 投标时间
     */
    private Date bidTime;

    /**
     * 投标状态
     */
    private Integer bidStatus;

    private static final long serialVersionUID = 1L;
}