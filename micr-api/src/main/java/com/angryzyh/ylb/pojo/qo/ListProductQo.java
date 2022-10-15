package com.angryzyh.ylb.pojo.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ListProductQo(访问list页面,请求参数)")
public class ListProductQo extends BasePageQo{

	@ApiModelProperty(value = "产品类型,1优选产品,2散标产品")
	private Integer productType;
}
