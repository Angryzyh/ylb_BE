package com.angryzyh.ylb.app;

import com.angryzyh.ylb.pojo.vo.IndexVo;
import com.angryzyh.ylb.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "index.html首页")
@RestController
@RequestMapping("/index")
public class IndexController extends BaseController{

    @ApiOperation(value = "首页banner图数据", notes = "平台产品历史平均年利率,平台用户数,平台总计成交额")
    @GetMapping("/banner")
    public R<IndexVo> queryIndexBannerInfo() {
        IndexVo bannerInfo = indexService.getBannerInfo();
        return R.ok(bannerInfo);
    }
}
