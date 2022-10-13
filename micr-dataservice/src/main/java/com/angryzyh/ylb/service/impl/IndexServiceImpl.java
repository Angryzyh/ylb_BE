package com.angryzyh.ylb.service.impl;

import com.angryzyh.ylb.constant.RedisKeyConstant;
import com.angryzyh.ylb.enums.ProductEnum;
import com.angryzyh.ylb.mapper.BidInfoMapper;
import com.angryzyh.ylb.mapper.ProductInfoMapper;
import com.angryzyh.ylb.mapper.UserMapper;
import com.angryzyh.ylb.pojo.bo.IndexBannerBo;
import com.angryzyh.ylb.pojo.bo.IndexProductListBo;
import com.angryzyh.ylb.pojo.po.ProductInfoPo;
import com.angryzyh.ylb.service.IndexService;
import com.angryzyh.ylb.util.ObjectMapperUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@DubboService(interfaceClass = IndexService.class,version = "0.0.1", timeout = 30000)
public class IndexServiceImpl implements IndexService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BidInfoMapper bidInfoMapper;

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Autowired
    @SuppressWarnings("all")
    StringRedisTemplate stringRedisTemplate;

    /**
     * 获取首页Banner图信息
     * @return IndexBannerBo
     */
    @Override
    public IndexBannerBo getBannerInfo() {
        IndexBannerBo indexBannerBo = null;
        // 先从Redis中查询
        String json = stringRedisTemplate.opsForValue().get(RedisKeyConstant.YLB_INDEX_BANNER);
        if (StringUtils.hasLength(json)) {
            indexBannerBo = ObjectMapperUtil.toObject(json, IndexBannerBo.class);
        } else {
            indexBannerBo = new IndexBannerBo();
            //获取历史平均年利率
            BigDecimal historyAvgRate = productInfoMapper.selectHistoryAvgRate();
            indexBannerBo.setHistoryAvgRate(historyAvgRate);
            //获取用户数量
            Integer userCount = userMapper.selectUserCount();
            indexBannerBo.setUserCounts(userCount);
            //获取平台累计成交金额
            BigDecimal allBidMoney = bidInfoMapper.selectAllBidMoney();
            indexBannerBo.setAllBidMoney(allBidMoney);
            // 把封装好的indexVo对象转成json串,塞进redis缓存
            String indexBannerBoJson = ObjectMapperUtil.toJSON(indexBannerBo);
            stringRedisTemplate.opsForValue().set(RedisKeyConstant.YLB_INDEX_BANNER, indexBannerBoJson, 60, TimeUnit.MINUTES);
        }
        return indexBannerBo;
    }

    /**
     * 获取首页产品信息列表
     *
     * @return IndexProductListBo
     */
    @Override
    public IndexProductListBo getProductList() {
        IndexProductListBo indexProductListBo = null;
        String json = stringRedisTemplate.opsForValue().get(RedisKeyConstant.YLB_INDEX_PRODUCT);
        if (StringUtils.hasLength(json)) {
            indexProductListBo = ObjectMapperUtil.toObject(json, IndexProductListBo.class);
        }else {
            List<ProductInfoPo> productList = productInfoMapper.selectList(null);
            List<ProductInfoPo> sortedProductList = productList
                    .stream()
                    .sorted(Comparator.comparing(ProductInfoPo::getRate).reversed())
                    .collect(Collectors.toList());
            List<ProductInfoPo> noviceProductList = sortedProductList
                    .stream()
                    .filter(x -> x.getProductType().equals(ProductEnum.Type.NOVICE_PRODUCT.getCode()))
                    .limit(1)
                    .collect(Collectors.toList());
            List<ProductInfoPo> preferredProductList = sortedProductList
                    .stream()
                    .filter(x -> x.getProductType().equals(ProductEnum.Type.PREFERRED_PRODUCT.getCode()))
                    .limit(3)
                    .collect(Collectors.toList());
            List<ProductInfoPo> scattererProductList = sortedProductList
                    .stream()
                    .filter(x -> x.getProductType().equals(ProductEnum.Type.SCATTERER_PRODUCT.getCode()))
                    .limit(3)
                    .collect(Collectors.toList());
            /*
                List<ProductInfoPo> noviceProductList = new ArrayList<>();
                List<ProductInfoPo> preferredProductList = new ArrayList<>();
                List<ProductInfoPo> scattererProductList = new ArrayList<>();
                productList.stream().sorted((x1, x2) -> {
                String s1 = x1.getRate().toString().replaceAll("\\.", "");
                Integer integer1 = Integer.valueOf(s1);
                String s2 = x2.getRate().toString().replaceAll("\\.", "");
                Integer integer2 = Integer.valueOf(s2);
                return integer2 - integer1;
            }).peek(x -> {
                if (Objects.equals(x.getProductType(), ProductEnum.Type.NOVICE_PRODUCT.getCode())) {
                    noviceProductList.add(x);
                }
            }).peek(x -> {
                if (Objects.equals(x.getProductType(), ProductEnum.Type.PREFERRED_PRODUCT.getCode())) {
                    preferredProductList.add(x);
                    System.out.println("x = " + x);
                }
            }).peek(x -> {
                if (Objects.equals(x.getProductType(), ProductEnum.Type.SCATTERER_PRODUCT.getCode())) {
                    scattererProductList.add(x);
                    System.out.println("x = " + x);
                }
            });
            noviceProductList.subList(0, 1);
            preferredProductList.subList(0, 3);
            scattererProductList.subList(0, 3);*/
            indexProductListBo = new IndexProductListBo(noviceProductList, preferredProductList, scattererProductList);
            // 再塞进redis
            String indexProductListBoJson = ObjectMapperUtil.toJSON(indexProductListBo);
            stringRedisTemplate.opsForValue().set(RedisKeyConstant.YLB_INDEX_PRODUCT,indexProductListBoJson,60,TimeUnit.MINUTES);
        }
        return indexProductListBo;
    }
}
