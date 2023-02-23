package com.baiyi.principle.liskovsubstitution.before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: 模拟信用卡功能
 * @author: BaiYi
 * @date: 2023/2/22 17:42
 */
public class CreditCard extends CashCard {
    private static final Logger logger = LoggerFactory.getLogger(CreditCard.class);

    @Override
    public String withdrawal(String orderId, BigDecimal amount) {
        // 校验
        if (amount.compareTo(new BigDecimal(1000)) >= 0){
            logger.info("贷款金额校验(限额1000元)，单号：{} 金额：{}", orderId, amount);
            return "0001";
        }
        // 模拟生成贷款单
        logger.info("生成贷款单，单号：{} 金额：{}", orderId, amount);
        // 模拟支付成功
        logger.info("贷款成功，单号：{} 金额：{}", orderId, amount);
        return "0000";
    }

    @Override
    public String recharge(String orderId, BigDecimal amount) {
        // 模拟生成还款单
        logger.info("生成还款单，单号：{} 金额：{}", orderId, amount);
        // 模拟还款成功
        logger.info("还款成功，单号：{} 金额：{}", orderId, amount);
        return "0000";
    }

    @Override
    public List<String> tradeFlow() {
        return super.tradeFlow();
    }
}
