package com.angryzyh.ylb.service;

import com.angryzyh.ylb.pojo.bo.IndexBannerBo;
import com.angryzyh.ylb.pojo.bo.IndexProductListBo;

public interface IndexService {

    IndexBannerBo getBannerInfo();

    IndexProductListBo getProductList();
}
