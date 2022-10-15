package com.angryzyh.ylb.app;

import com.angryzyh.ylb.service.BidInfoService;
import com.angryzyh.ylb.service.IndexService;
import com.angryzyh.ylb.service.ProductInfoService;
import org.apache.dubbo.config.annotation.DubboReference;

public class BaseController {

    @DubboReference(interfaceClass = IndexService.class, version = "0.0.1", timeout = 30000)
    protected IndexService indexService;

    @DubboReference(interfaceClass = BidInfoService.class, version = "0.0.1", timeout = 30000)
    protected BidInfoService bidInfoService;

    @DubboReference(interfaceClass = ProductInfoService.class, version = "0.0.1", timeout = 30000)
    protected ProductInfoService productInfoService;
}
