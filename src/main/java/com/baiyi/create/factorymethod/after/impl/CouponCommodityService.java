package com.baiyi.create.factorymethod.after.impl;

import com.alibaba.fastjson.JSON;
import com.baiyi.create.factorymethod.after.ICommodity;
import com.baiyi.create.factorymethod.base.card.IQiYiCardService;
import com.baiyi.create.factorymethod.base.coupon.CouponResult;
import com.baiyi.create.factorymethod.base.coupon.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description: 优惠券
 * @author: BaiYi
 * @date: 2023/2/24 21:13
 */
public class CouponCommodityService implements ICommodity {

    public static final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    // 模拟注入
    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] ==> uId: {} commodityId: {} bizId: {} extMap: {}", uId, commodityId, bizId, extMap);
        logger.info("测试结束[优惠券]: {}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}
