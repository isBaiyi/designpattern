package com.baiyi.principle;

import com.alibaba.fastjson.JSON;
import com.baiyi.principle.dependenceinversion.after.DrawRandom;
import com.baiyi.principle.dependenceinversion.after.DrawWeightRank;
import com.baiyi.principle.dependenceinversion.before.BetUser;
import com.baiyi.principle.dependenceinversion.before.DrawControl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 依赖倒置原则单元测试
 * @author: BaiYi
 * @date: 2023/2/23 18:07
 */
class DependenceInversionTest {
    private static final Logger logger = LoggerFactory.getLogger(DependenceInversionTest.class);

    /**
     * 用于测试: 未使用依赖倒置原则进行实现抽奖功能。
     * 这样的实现方式扩展起来很麻烦，每次扩展都需要新增接口，同时对于调用方来说需要新增调用接口的代码。
     * 其次，对于这个服务类来说，随着接口数量的增加，代码行数会不断地暴增，最后难以维护。
     */
    @Test
    void test_before() {
        List<BetUser> betUserList = new ArrayList<>();
        betUserList.add(new BetUser("花花", 65));
        betUserList.add(new BetUser("豆豆", 43));
        betUserList.add(new BetUser("小白", 72));
        betUserList.add(new BetUser("笨笨", 89));
        betUserList.add(new BetUser("丑蛋", 10));

        DrawControl drawControl = new DrawControl();
        List<BetUser> prizeRandomUserList = drawControl.doDrawRandom(betUserList, 3);
        logger.info("随机抽奖，中奖用户名单：{}", JSON.toJSON(prizeRandomUserList));

        List<BetUser> prizeWeightUserList = drawControl.doDrawWeight(betUserList, 3);
        logger.info("权重抽奖，中奖用户名单：{}", JSON.toJSON(prizeWeightUserList));
    }

    /**
     * 用于测试: 使用依赖倒置原则后进行抽奖功能。
     * 在这个DrawControl类中体现了依赖倒置的重要性，可以把任何一种抽奖逻辑传递给这个类。这样实现的好处是可以不断地扩展，
     * 但是不需要在外部新增调用接口，降低了一套代码的维护成本，并提高了可扩展性及可维护性。
     */
    @Test
    void test_after() {
        List<com.baiyi.principle.dependenceinversion.after.BetUser> betUserList = new ArrayList<>();
        betUserList.add(new com.baiyi.principle.dependenceinversion.after.BetUser("花花", 65));
        betUserList.add(new com.baiyi.principle.dependenceinversion.after.BetUser("豆豆", 43));
        betUserList.add(new com.baiyi.principle.dependenceinversion.after.BetUser("小白", 72));
        betUserList.add(new com.baiyi.principle.dependenceinversion.after.BetUser("笨笨", 89));
        betUserList.add(new com.baiyi.principle.dependenceinversion.after.BetUser("丑蛋", 10));

        com.baiyi.principle.dependenceinversion.after.DrawControl drawControl =
                new com.baiyi.principle.dependenceinversion.after.DrawControl();
        List<com.baiyi.principle.dependenceinversion.after.BetUser> prizeRandomUserList = drawControl.doDraw(new DrawRandom(),
                betUserList, 3);
        logger.info("随机抽奖，中奖用户名单：{}", JSON.toJSON(prizeRandomUserList));

        List<com.baiyi.principle.dependenceinversion.after.BetUser> prizeWeightUserList =
                drawControl.doDraw(new DrawWeightRank(), betUserList, 3);
        logger.info("权重抽奖，中奖用户名单：{}", JSON.toJSON(prizeWeightUserList));
    }
}

