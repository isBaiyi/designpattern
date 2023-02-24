package com.baiyi.create.factorymethod.after;

import com.baiyi.create.factorymethod.after.impl.CardCommodityService;
import com.baiyi.create.factorymethod.after.impl.CouponCommodityService;
import com.baiyi.create.factorymethod.after.impl.GoodsCommodityService;

/**
 * @description: 工厂方法
 * @author: BaiYi
 * @date: 2023/2/24 21:24
 */
public class StoreFactory {

    /**
     * 奖品类型方式实例化
     *
     * @param commodityType 奖品类型
     * @return 实例化对象
     */
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new UnsupportedOperationException("不存在的奖品服务类型");
    }

    /**
     * 奖品类信息方式实例化
     *
     * @param clazz 奖品类
     * @return 实例化对象
     * @throws InstantiationException 实例失败异常
     * @throws IllegalAccessException
     */
    public ICommodity getCommodityService(Class<? extends ICommodity> clazz) throws InstantiationException,
            IllegalAccessException {
        if (null == clazz) return null;
        return clazz.newInstance();
    }
}
