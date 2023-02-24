package com.baiyi.create.factorymethod.base.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 优惠券返回结果类
 * @author: BaiYi
 * @date: 2023/2/24 14:37
 */
@Data
@AllArgsConstructor
public class CouponResult {
    private String code; // 编码
    private String info; // 描述
}
