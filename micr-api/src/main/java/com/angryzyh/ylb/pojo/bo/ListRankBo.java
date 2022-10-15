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
@ApiModel(value = "ListRankBo(list页面,投资排行榜Bo对象")
public class ListRankBo implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "投资排行榜名次")
	private Integer rankNum;
	@ApiModelProperty(value = "用户手机号码")
	private String phone;
	@ApiModelProperty(value = "用户平台投资总金额")
	private BigDecimal bidMoney;
}
