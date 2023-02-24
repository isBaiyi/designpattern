package com.baiyi.principle.dependenceinversion.before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 抽奖逻辑实现类
 * @author: BaiYi
 * @date: 2023/2/23 18:03
 */
public class DrawControl {

    /**
     * 随机抽取指定数量的用户，作为中奖用户
     *
     * @param list  用户列表
     * @param count 抽奖数量
     * @return 中奖用户
     */
    public List<BetUser> doDrawRandom(List<BetUser> list, int count) {
        // 集合数量很小直接返回
        if (list.size() <= count) return list;
        // 乱序集合
        Collections.shuffle(list);
        // 取出指定数量的中奖用户
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(list.get(i));
        }
        return prizeList;
    }

    /**
     * 权重排名获取指定数量的用户，作为中奖用户
     *
     * @param list  用户列表
     * @param count 抽奖数量
     * @return 中奖用户
     */
    public List<BetUser> doDrawWeight(List<BetUser> list, int count) {
        // 按照权重排序
        list.sort((o1, o2) -> {
            int e = o2.getUserWeight() - o1.getUserWeight();
            if (0 == e) return 0;
            return e > 0 ? 1 : -1;
        });
        // 取出指定数量的中奖用户
        List<BetUser> prizeList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            prizeList.add(list.get(i));
        }
        return prizeList;
    }
}
