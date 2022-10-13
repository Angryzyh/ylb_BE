package com.angryzyh.ylb.pojo.vo;

import com.angryzyh.ylb.pojo.bo.IndexBannerBo;
import com.angryzyh.ylb.pojo.bo.IndexProductListBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "IndexVo(后端响应index页面数据)")
public class IndexVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "首页Banner图信息Bo对象")
    private IndexBannerBo indexBannerBo;
    @ApiModelProperty(value = "首页产品列表Bo对象")
    private IndexProductListBo indexProductListBo;
}
