package com.angryzyh.ylb.pojo.bo;

import com.angryzyh.ylb.pojo.po.ProductInfoPo;
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
@ApiModel(value = "IndexProductListBo(首页产品列表Bo对象)")
public class IndexProductListBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /* 新手宝产品列表 */
    @ApiModelProperty(value = "新手宝产品列表")
    private List<ProductInfoPo> noviceList;
    /* 优选产品列表 */
    @ApiModelProperty(value = "优选产品列表", position = 1)
    private List<ProductInfoPo> preferredList;
    /* 散标产品列表 */
    @ApiModelProperty(value = "散标产品列表", position = 2)
    private List<ProductInfoPo> scattererList;
}
