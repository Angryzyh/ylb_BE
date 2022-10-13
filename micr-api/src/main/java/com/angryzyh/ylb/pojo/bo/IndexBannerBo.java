package com.angryzyh.ylb.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "IndexBannerBo(首页Banner图信息Bo对象)")
public class IndexBannerBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /* 历史平均年化收益率 */
    @ApiModelProperty(value = "平台产品历史平均年利率")
    private BigDecimal historyAvgRate;
    /* 平台的用户数量 */
    @ApiModelProperty(value = "平台的用户数量", position = 1)
    private Integer userCounts;
    /* 平台累计成交金额 */
    @ApiModelProperty(value = "平台累计成交总金额", position = 2)
    private BigDecimal allBidMoney;
}
