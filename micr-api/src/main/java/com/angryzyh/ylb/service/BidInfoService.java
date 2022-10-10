package com.angryzyh.ylb.service;

import com.angryzyh.ylb.pojo.po.BidInfoPo;

import java.math.BigDecimal;

/**
* @author Angryzyh
* @description 针对表【b_bid_info(投资记录表)】的数据库操作Service
* @createDate 2022-10-09 14:23:21
*/
public interface BidInfoService {
    // 查询 平台总投资金额
    BigDecimal getAllBidMoney();
}
