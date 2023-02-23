package com.baiyi.principle;

import com.alibaba.fastjson.JSON;
import com.baiyi.principle.liskovsubstitution.before.CashCard;
import com.baiyi.principle.liskovsubstitution.before.CreditCard;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: 里氏替换原则单元测试
 * @author: BaiYi
 * @date: 2023/2/22 17:45
 */
class LiskovSubstitutionTest {
    private static final Logger logger = LoggerFactory.getLogger(LiskovSubstitutionTest.class);

    /**
     * 用于测试: 未使用里氏替换原则的储蓄卡消费功能
     */
    @Test
    void test_before_cashCard() {
        CashCard cashCard = new CashCard();
        // 提现
        cashCard.withdrawal("100001", new BigDecimal(100));
        // 储蓄
        cashCard.recharge("100001", new BigDecimal(100));
        // 交易流水
        List<String> tradeFlow = cashCard.tradeFlow();
        logger.info("查询交易流水，{}", JSON.toJSONString(tradeFlow));
    }

    /**
     * 用于测试: 未使用里氏替换原则的信用卡消费功能
     */
    @Test
    void test_before_creditCard() {
        CreditCard creditCard = new CreditCard();
        // 支付
        creditCard.withdrawal("100001", new BigDecimal(100));
        // 还款
        creditCard.recharge("100001", new BigDecimal(100));
        // 交易流水
        List<String> tradeFlow = creditCard.tradeFlow();
        logger.info("查询交易流水，{}", JSON.toJSONString(tradeFlow));
    }

    /**
     * 用于测试: 使用里氏替换原则的储蓄卡消费功能
     */
    @Test
    void test_after_cashCard() {
        com.baiyi.principle.liskovsubstitution.after.CashCard cashCard =
                new com.baiyi.principle.liskovsubstitution.after.CashCard("20918321", "2023-02-23");
        cashCard.withdrawal("100001", new BigDecimal(1000));
        cashCard.withdrawal("100002", new BigDecimal(1500));
    }
}
