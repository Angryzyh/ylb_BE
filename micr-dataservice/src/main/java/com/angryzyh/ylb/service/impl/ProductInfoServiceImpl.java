package com.angryzyh.ylb.service.impl;

import com.angryzyh.ylb.enums.ProductEnum;
import com.angryzyh.ylb.pojo.bo.IndexProductListBo;
import com.angryzyh.ylb.service.IndexService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.angryzyh.ylb.pojo.po.ProductInfoPo;
import com.angryzyh.ylb.service.ProductInfoService;
import com.angryzyh.ylb.mapper.ProductInfoMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
* @author Angryzyh
* @description 针对表【b_product_info(产品信息表)】的数据库操作Service实现
* @createDate 2022-10-09 14:23:21
*/
@Service
@DubboService(interfaceClass = ProductInfoService.class,version = "0.0.1", timeout = 30000)
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfoPo> implements ProductInfoService{

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public BigDecimal getHistoryAvgRate() {
        return productInfoMapper.selectHistoryAvgRate();
    }

    @Override
    public Page<ProductInfoPo> getProductListByPage(Integer productType, Integer currentPage, Integer pageSize) {
        Page<ProductInfoPo> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<ProductInfoPo> queryWrapper = new LambdaQueryWrapper<>();
        if (ProductEnum.Type.checkProductTypeUtil(productType)) {
            queryWrapper.eq(ProductInfoPo::getProductType, productType);
        }
        return productInfoMapper.selectPage(page, queryWrapper);
    }
}




