package com.angryzyh.ylb.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexVo implements Serializable {
    /* 历史平均年化收益率 */
    private BigDecimal historyAvgRate;

    /* 平台的用户数量 */
    private Integer userCounts;

    /* 平台累计成交金额 */
    private BigDecimal allBidMoney;

    private static final long serialVersionUID = 1L;
}
