package com.angryzyh.ylb.app;

import cn.hutool.core.util.DesensitizedUtil;
import com.angryzyh.ylb.pojo.bo.ListRankBo;
import com.angryzyh.ylb.pojo.po.ProductInfoPo;
import com.angryzyh.ylb.pojo.qo.ListProductQo;
import com.angryzyh.ylb.pojo.vo.ListVo;
import com.angryzyh.ylb.util.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "list.html投资列表页面")
@CrossOrigin
@RestController
@RequestMapping("/list")
public class ListController extends BaseController {

	@ApiOperation(value = "list页面投资排行榜", notes = "排名,用户手机号,用户总投资金额")
	@GetMapping("/rank")
	public R<ListVo> queryListRankInfo() {
		List<ListRankBo> bidMoneyRank = bidInfoService.getBidMoneyRank();
		if (bidMoneyRank == null) {
			return R.fail("投资排行榜数据异常");
		} else {
			// 手机号脱敏
			bidMoneyRank.forEach(x -> x.setPhone(DesensitizedUtil.mobilePhone(x.getPhone())));
			ListVo listVo = new ListVo();
			listVo.setListRankBos(bidMoneyRank);
			return R.ok(listVo);
		}
	}

	@ApiOperation(value = "list页面产品展示", notes = "优选产品或者散标产品")
	@GetMapping("/product")
	public R<ListVo> queryListProductInfo(ListProductQo listProductQo) {
		Page<ProductInfoPo> productListByPage = productInfoService.getProductListByPage(listProductQo.getProductType(), listProductQo.getCurrentPage(), listProductQo.getPageSize());
		ListVo listVo = new ListVo();
		listVo.setListProductPage(productListByPage);
		return R.ok(listVo);
	}
}
