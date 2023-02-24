package com.baiyi.principle.dependenceinversion.after;

import java.util.List;

/**
 * @description: 抽奖控制器
 * @author: BaiYi
 * @date: 2023/2/24 11:02
 */
public class DrawControl {
    private IDraw draw;

    public List<BetUser> doDraw(IDraw draw, List<BetUser> userList, int count) {
        return draw.prize(userList, count);
    }
}
