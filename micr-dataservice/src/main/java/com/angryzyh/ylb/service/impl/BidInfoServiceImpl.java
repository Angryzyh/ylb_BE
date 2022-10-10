package com.angryzyh.ylb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.angryzyh.ylb.pojo.po.BidInfoPo;
import com.angryzyh.ylb.service.BidInfoService;
import com.angryzyh.ylb.mapper.BidInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
* @author Angryzyh
* @description 针对表【b_bid_info(投资记录表)】的数据库操作Service实现
* @createDate 2022-10-09 14:23:21
*/
@Service
public class BidInfoServiceImpl extends ServiceImpl<BidInfoMapper, BidInfoPo> implements BidInfoService{

    @Autowired
    BidInfoMapper bidInfoMapper;

    @Override
    public BigDecimal getAllBidMoney() {
        return bidInfoMapper.selectAllBidMoney();
    }
}




