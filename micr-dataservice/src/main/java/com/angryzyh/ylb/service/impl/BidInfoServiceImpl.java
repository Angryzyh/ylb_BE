package com.angryzyh.ylb.service.impl;

import com.angryzyh.ylb.constant.RedisKeyConstant;
import com.angryzyh.ylb.mapper.BidInfoMapper;
import com.angryzyh.ylb.mapper.UserMapper;
import com.angryzyh.ylb.pojo.bo.ListRankBo;
import com.angryzyh.ylb.pojo.po.BidInfoPo;
import com.angryzyh.ylb.pojo.po.UserPo;
import com.angryzyh.ylb.service.BidInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Angryzyh
 * @description 针对表【b_bid_info(投资记录表)】的数据库操作Service实现
 * @createDate 2022-10-09 14:23:21
 */
@Service
@DubboService(interfaceClass = BidInfoService.class, version = "0.0.1", timeout = 30000)
public class BidInfoServiceImpl extends ServiceImpl<BidInfoMapper, BidInfoPo> implements BidInfoService {

	@Autowired
	BidInfoMapper bidInfoMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	@SuppressWarnings("all")
	StringRedisTemplate stringRedisTemplate;

	@Override
	public BigDecimal getAllBidMoney() {
		return bidInfoMapper.selectAllBidMoney();
	}

	@Override
	public List<ListRankBo> getBidMoneyRank() {
		List<ListRankBo> listRankBos;
		Set<ZSetOperations.TypedTuple<String>> rankSet = stringRedisTemplate.opsForZSet().reverseRangeWithScores(RedisKeyConstant.YLB_LIST_RANK, 0, 2);
		if (rankSet != null && rankSet.size() > 0) {
			listRankBos = getRankList(rankSet);
		} else {
			synchronized (this) {
				rankSet = stringRedisTemplate.opsForZSet().reverseRangeWithScores(RedisKeyConstant.YLB_LIST_RANK, 0, 2);
				if (rankSet != null && rankSet.size() > 0) {
					listRankBos = getRankList(rankSet);
				} else {
					List<BidInfoPo> bidInfoPos = bidInfoMapper.selectList(new QueryWrapper<BidInfoPo>()
						.select("uid", "sum(bid_money) as bidMoney")
						.groupBy("uid")
						.orderByDesc("bidMoney"));
					List<Integer> uid = bidInfoPos
						.stream()
						.map(BidInfoPo::getUid)
						.collect(Collectors.toList());
					List<UserPo> userPos = userMapper.selectList(new LambdaQueryWrapper<UserPo>()
						.select(UserPo::getId, UserPo::getPhone)
						.in(UserPo::getId, uid));
					AtomicInteger i = new AtomicInteger(0);
					listRankBos = bidInfoPos
						.stream()
						.map(x -> {
							ListRankBo listRankBo = new ListRankBo();
							listRankBo.setRankNum(i.addAndGet(1));
							listRankBo.setBidMoney(x.getBidMoney());
							userPos.forEach(user -> {
								if (Objects.equals(x.getUid(), user.getId())) {
									listRankBo.setPhone(user.getPhone());
								}
							});
							return listRankBo;
						})
						.collect(Collectors.toList());
					Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
					listRankBos.forEach(x -> tuples.add(ZSetOperations.TypedTuple.of(x.getPhone(), x.getBidMoney().doubleValue())));
					stringRedisTemplate.opsForZSet().add(RedisKeyConstant.YLB_LIST_RANK, tuples);
					if (listRankBos.size() > 3) {
						listRankBos.subList(0, 3);
					}
				}
			}
		}
		return listRankBos;
	}

	private List<ListRankBo> getRankList(Set<ZSetOperations.TypedTuple<String>> rankSet) {
		List<ListRankBo> listRankBos = new ArrayList<>();
		AtomicInteger i = new AtomicInteger(0);
		rankSet.forEach(x -> {
			ListRankBo listRankBo = new ListRankBo();
			listRankBo.setPhone(x.getValue());
			listRankBo.setBidMoney(BigDecimal.valueOf(x.getScore()!=null ? x.getScore() :0));
			listRankBo.setRankNum(i.addAndGet(1));
			listRankBos.add(listRankBo);
		});
		return listRankBos;
	}
}




