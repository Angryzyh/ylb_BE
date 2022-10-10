package com.angryzyh.ylb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.angryzyh.ylb.pojo.po.ProductInfoPo;
import com.angryzyh.ylb.service.ProductInfoService;
import com.angryzyh.ylb.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
* @author Angryzyh
* @description 针对表【b_product_info(产品信息表)】的数据库操作Service实现
* @createDate 2022-10-09 14:23:21
*/
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfoPo> implements ProductInfoService{

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public BigDecimal getHistoryAvgRate() {
        return productInfoMapper.selectHistoryAvgRate();
    }
}




