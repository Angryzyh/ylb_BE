package com.angryzyh.ylb.app;

import com.angryzyh.ylb.service.IndexService;
import org.apache.dubbo.config.annotation.DubboReference;

public class BaseController {

    @DubboReference(interfaceClass = IndexService.class, version = "0.0.1", timeout = 30000)
    protected IndexService indexService;

}
