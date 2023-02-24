package com.baiyi.principle.dependenceinversion.before;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 抽奖用户
 * @author: BaiYi
 * @date: 2023/2/23 18:01
 */
@Data
@AllArgsConstructor
public class BetUser {
    private String username; //用户名称
    private int userWeight; //用户权重
}
