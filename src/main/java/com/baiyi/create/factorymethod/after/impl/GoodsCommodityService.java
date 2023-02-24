package com.baiyi.create.factorymethod.after.impl;

import com.alibaba.fastjson.JSON;
import com.baiyi.create.factorymethod.after.ICommodity;
import com.baiyi.create.factorymethod.base.coupon.CouponResult;
import com.baiyi.create.factorymethod.base.coupon.CouponService;
import com.baiyi.create.factorymethod.base.goods.DeliverReq;
import com.baiyi.create.factorymethod.base.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description: 实物奖品
 * @author: BaiYi
 * @date: 2023/2/24 21:13
 */
public class GoodsCommodityService implements ICommodity {

    public static final Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    // 模拟注入
    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[实物商品] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[实物商品]：{}", isSuccess);

        if (!isSuccess) throw new RuntimeException("实物商品发放失败");
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
