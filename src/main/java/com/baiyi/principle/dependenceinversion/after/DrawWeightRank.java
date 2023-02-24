package com.baiyi.principle.dependenceinversion.after;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 权重排名获取指定数量的用户，作为中奖用户
 * @author: BaiYi
 * @date: 2023/2/24 11:01
 */
public class DrawWeightRank implements IDraw {
    @Override
    public List<BetUser> prize(List<BetUser> userList, int count) {
        // 按照权重排序
        userList.sort((o1, o2) -> {
            int e = o2.getUserWeight() - o1.getUserWeight();
            if (0 == e) return 0;
            return e > 0 ? 1 : -1;
        });
        // 取出指定数量的中奖用户
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(userList.get(i));
        }
        return prizeList;
    }
}
