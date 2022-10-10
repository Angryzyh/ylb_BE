package com.angryzyh.ylb.service;

import com.angryzyh.ylb.pojo.po.ProductInfoPo;

import java.math.BigDecimal;

/**
 * @author Angryzyh
 * @description 针对表【b_product_info(产品信息表)】的数据库操作Service
 * @createDate 2022-10-09 14:23:21
 */
public interface ProductInfoService {

    //获取 平台产品历史平均年化收益率
    BigDecimal getHistoryAvgRate();

}
