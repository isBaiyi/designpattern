package com.baiyi.create;

import com.alibaba.fastjson.JSON;
import com.baiyi.create.factorymethod.after.ICommodity;
import com.baiyi.create.factorymethod.after.StoreFactory;
import com.baiyi.create.factorymethod.after.impl.CouponCommodityService;
import com.baiyi.create.factorymethod.before.AwardReq;
import com.baiyi.create.factorymethod.before.AwardRes;
import com.baiyi.create.factorymethod.before.PrizeController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @description: 工厂方法单元测试
 * @author: BaiYi
 * @date: 2023/2/24 14:49
 */
class FactoryMethodTest {

    private static final Logger logger = LoggerFactory.getLogger(FactoryMethodTest.class);

    /**
     * 用于测试: 未使用工厂方法模式进行模拟抽奖活动，使用 if...else...方式实现。
     * 虽然运行结果正常，满足当前所有的业务产品需求，但这样的实现方式不易于扩展，也非常难以维护，风险很高。
     */
    @Test
    void test_before_awardToUser() {
        PrizeController prizeController = new PrizeController();

        System.out.println("\r\n模拟发放优惠券测试\r\n");
        // 模拟发放优惠券测试
        AwardReq req01 = new AwardReq();
        req01.setuId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM1023938910232121323432");
        req01.setBizId("791098764902132");
        AwardRes awardRes01 = prizeController.awardToUser(req01);

        logger.info("请求参数：{}", JSON.toJSON(req01));
        logger.info("测试结果：{}", JSON.toJSON(awardRes01));

        System.out.println("\r\n模拟方法实物商品\r\n");
        // 模拟方法实物商品
        AwardReq req02 = new AwardReq();
        req02.setuId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber("9820198721311");
        req02.setBizId("1023000020112221113");
        req02.setExtMap(new HashMap<String, String>() {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        }});

        AwardRes awardRes02 = prizeController.awardToUser(req02);
        logger.info("请求参数：{}", JSON.toJSON(req02));
        logger.info("测试结果：{}", JSON.toJSON(awardRes02));

        System.out.println("\r\n第三方兑换卡(爱奇艺)\r\n");
        AwardReq req03 = new AwardReq();
        req03.setuId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");

        AwardRes awardRes03 = prizeController.awardToUser(req03);
        logger.info("请求参数：{}", JSON.toJSON(req03));
        logger.info("测试结果：{}", JSON.toJSON(awardRes03));

    }

    @Test
    void test_StoreFactory_01() throws Exception {
        StoreFactory storeFactory = new StoreFactory();

        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);

        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);
        commodityService_2.sendCommodity("10001", "9820198721311", "1023000020112221113", new HashMap<String, String>() {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        }});

        // 3. 第三方兑换卡(模拟爱奇艺)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);

    }

    @Test
    void test_StoreFactory_02() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. 优惠券
        ICommodity commodityService = storeFactory.getCommodityService(CouponCommodityService.class);
        commodityService.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
    }

}
