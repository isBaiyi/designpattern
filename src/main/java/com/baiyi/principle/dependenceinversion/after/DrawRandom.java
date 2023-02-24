package com.baiyi.principle.dependenceinversion.after;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 随机抽取指定数量的用户，作为中奖用户
 * @author: BaiYi
 * @date: 2023/2/24 10:59
 */
public class DrawRandom implements IDraw{

    @Override
    public List<BetUser> prize(List<BetUser> userList, int count) {
        // 集合数量很小直接返回
        if (userList.size() <= count) return userList;
        // 乱序集合
        Collections.shuffle(userList);
        // 取出指定数量的中奖用户
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(userList.get(i));
        }
        return prizeList;
    }
}
