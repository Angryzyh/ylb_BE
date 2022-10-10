package com.angryzyh.ylb.service.impl;

import com.angryzyh.ylb.mapper.BidInfoMapper;
import com.angryzyh.ylb.mapper.ProductInfoMapper;
import com.angryzyh.ylb.mapper.UserMapper;
import com.angryzyh.ylb.pojo.vo.IndexVo;
import com.angryzyh.ylb.service.IndexService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@DubboService(interfaceClass = IndexService.class,version = "0.0.1", timeout = 20000)
public class IndexServiceImpl implements IndexService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BidInfoMapper bidInfoMapper;

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public IndexVo getBannerInfo() {
        //获取历史平均年利率
        BigDecimal historyAvgRate = productInfoMapper.selectHistoryAvgRate();
        //获取用户数量
        Integer userCount = userMapper.selectUserCount();
        //获取平台累计成交金额
        BigDecimal allBidMoney = bidInfoMapper.selectAllBidMoney();
        IndexVo indexVo = new IndexVo();
        indexVo.setHistoryAvgRate(historyAvgRate);
        indexVo.setUserCounts(userCount);
        indexVo.setAllBidMoney(allBidMoney);
        return indexVo;
    }
}
