package com.angryzyh.ylb.app;

import com.angryzyh.ylb.pojo.vo.IndexVo;
import com.angryzyh.ylb.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController extends BaseController{

    @GetMapping("/banner")
    public R queryIndexBannerInfo() {
        IndexVo bannerInfo = indexService.getBannerInfo();
        return R.ok(bannerInfo);
    }
}
