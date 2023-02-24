package com.baiyi.create.factorymethod.base.goods;

import com.alibaba.fastjson.JSON;

/**
 * @description: 模拟实物商品服务
 * @author: BaiYi
 * @date: 2023/2/24 14:40
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }

}
