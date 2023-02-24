package com.baiyi.create.factorymethod.after.impl;

import com.baiyi.create.factorymethod.after.ICommodity;
import com.baiyi.create.factorymethod.base.card.IQiYiCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description: 实物卡
 * @author: BaiYi
 * @date: 2023/2/24 21:13
 */
public class CardCommodityService implements ICommodity {

    public static final Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        logger.info("请求参数[爱奇艺兑换卡] ==> uId: {} commodityId: {} bizId: {} extMap: {}", uId, commodityId, bizId, extMap);
        logger.info("测试结束[爱奇艺兑换卡]: success");
    }

    private String queryUserMobile(String uId) {
        return "16625356151";
    }
}
