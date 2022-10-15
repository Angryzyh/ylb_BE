package com.angryzyh.ylb.pojo.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BasePageQo(分页请求基本参数)")
public class BasePageQo {

	@ApiModelProperty(value = "当前页码")
	private Integer currentPage;

	@ApiModelProperty(value = "每页数据量")
	private Integer pageSize;
}
