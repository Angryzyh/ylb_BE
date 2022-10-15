package com.angryzyh.ylb.app;

import com.angryzyh.ylb.pojo.bo.IndexBannerBo;
import com.angryzyh.ylb.pojo.bo.IndexProductListBo;
import com.angryzyh.ylb.pojo.vo.IndexVo;
import com.angryzyh.ylb.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "index.html首页")
@CrossOrigin
@RestController
@RequestMapping("/index")
public class IndexController extends BaseController{

    @ApiOperation(value = "首页banner图数据", notes = "平台产品历史平均年利率,平台用户数,平台总计成交额")
    @GetMapping("/banner")
    public R<IndexVo> queryIndexBannerInfo() {
        IndexVo indexVo = new IndexVo();
        IndexBannerBo bannerInfo = indexService.getBannerInfo();
        if (bannerInfo == null) {
            return R.fail("首页Banner基本信息缺失");
        } else {
            indexVo.setIndexBannerBo(bannerInfo);
            return R.ok(indexVo);
        }
    }

    @ApiOperation(value = "首页产品信息", notes = "新手宝,优选产品,散标产品")
    @GetMapping("/product")
    public R<IndexVo> queryIndexProductInfo() {
        IndexVo indexVo = new IndexVo();
        IndexProductListBo productList = indexService.getProductList();
        if (productList == null) {
            return R.fail("首页产品信息缺失");
        }else {
            indexVo.setIndexProductListBo(productList);
            return R.ok(indexVo);
        }
    }
}
