package com.baiyi.create.factorymethod.base.coupon;

/**
 * @description: 模拟优惠券服务
 * @author: BaiYi
 * @date: 2023/2/24 14:38
 */
public class CouponService {

    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }

}
