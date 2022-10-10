package com.angryzyh.ylb.mapper;

import com.angryzyh.ylb.pojo.po.BidInfoPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author Angryzyh
 * @description 针对表【b_bid_info(投资记录表)】的数据库操作Mapper
 * @createDate 2022-10-09 14:23:21
 * @Entity com.angryzyh.ylb.pojo.po.BidInfoPo
 */
@Repository
public interface BidInfoMapper extends BaseMapper<BidInfoPo> {

    BigDecimal selectAllBidMoney();

}




