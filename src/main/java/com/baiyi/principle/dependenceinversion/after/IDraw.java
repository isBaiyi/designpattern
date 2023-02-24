package com.baiyi.principle.dependenceinversion.after;

import java.util.List;

/**
 * @description: 抽奖接口
 * @author: BaiYi
 * @date: 2023/2/24 10:57
 */
public interface IDraw {
    /**
     * 抽奖接口
     *
     * @param userList 参与抽奖用户列表
     * @param count    抽奖数量
     * @return 中奖用户列表
     */
    List<BetUser> prize(List<BetUser> userList, int count);
}
