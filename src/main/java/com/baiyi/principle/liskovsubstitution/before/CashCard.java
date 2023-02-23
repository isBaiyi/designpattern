package com.baiyi.principle.liskovsubstitution.before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 模拟储蓄卡功能
 * @author: BaiYi
 * @date: 2023/2/22 17:34
 */
public class CashCard {

    private static final Logger logger = LoggerFactory.getLogger(CashCard.class);

    /**
     * 提现
     *
     * @param orderId 单号
     * @param amount  余额
     * @return 状态码 0000成功 0001失败 0002重复
     */
    public String withdrawal(String orderId, BigDecimal amount) {
        // 模拟支付成功
        logger.info("提现成功，单号: {} 余额: {}", orderId, amount);
        return "0000";
    }

    /**
     * 储蓄
     *
     * @param orderId 单号
     * @param amount  金额
     * @return 状态码 0000成功 0001失败 0002重复
     */
    public String recharge(String orderId, BigDecimal amount) {
        // 模拟充值成功
        logger.info("充值成功，单号: {} 余额: {}", orderId, amount);
        return "0000";
    }

    /**
     * 查询交易流水
     *
     * @return 交易流水
     */
    public List<String> tradeFlow() {
        logger.info("交易流水查询成功");
        List<String> tradeList = new ArrayList<>();
        tradeList.add("100001,100.00");
        tradeList.add("100001,80.00");
        tradeList.add("100001,75.00");
        tradeList.add("100001,125.00");
        return tradeList;
    }
}
