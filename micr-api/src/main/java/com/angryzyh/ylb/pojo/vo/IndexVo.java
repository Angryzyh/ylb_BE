package com.angryzyh.ylb.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "IndexVo",description ="后端响应index页面数据" )
public class IndexVo implements Serializable {

    /* 历史平均年化收益率 */
    @ApiModelProperty(value = "历史平均年利率",notes = "平台产品历史平均年利率",dataType = "BigDecimal")
    private BigDecimal historyAvgRate;

    /* 平台的用户数量 */
    @ApiModelProperty(value = "用户数量",notes = "平台的用户数量",dataType = "Integer")
    private Integer userCounts;

    /* 平台累计成交金额 */
    @ApiModelProperty(value = "成交金额",notes = "平台累计成交总金额",dataType = "BigDecimal")
    private BigDecimal allBidMoney;

    private static final long serialVersionUID = 1L;
}
