package com.angryzyh.ylb.pojo.vo;

import com.angryzyh.ylb.pojo.bo.ListRankBo;
import com.angryzyh.ylb.pojo.po.ProductInfoPo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ListVo(后端响应list页面数据)")
public class ListVo implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "list页面,投资排行榜Bo对象")
	private List<ListRankBo> listRankBos;

	@ApiModelProperty(value = "list页面,产品列表分页对象")
	private Page<ProductInfoPo> listProductPage;

}
