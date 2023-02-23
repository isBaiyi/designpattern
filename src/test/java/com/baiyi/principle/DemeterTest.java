package com.baiyi.principle;

import com.alibaba.fastjson.JSON;
import com.baiyi.principle.demeter.before.Principal;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @description: 迪米特法则单元测试
 * @author: BaiYi
 * @date: 2023/2/23 14:51
 */
class DemeterTest {
    private static final Logger logger = LoggerFactory.getLogger(DemeterTest.class);

    /**
     * 用于测试: 使用迪米特法则之前的校长获取班级信息，不经过教师，都是自己亲力亲为。
     * 违背了迪米特法则，因为校长需要了解每个学生的情况。如果所有班级都让校长类统计，代码就会变得非常臃肿，也不易于维护和扩展。
     */
    @Test
    void test_before() {
        Principal principal = new Principal();
        Map<String, Object> queryClazzInfo = principal.queryClazzInfo("10001");
        logger.info("查询班级信息为：{}", JSON.toJSONString(queryClazzInfo));
    }

    /**
     * 用于测试: 使用迪米特法则的校长获取班级信息，只需要询问对应的教师即可获取班级信息。减少耦合，完成了最少知道原则。
     */
    @Test
    void test_after() {
        com.baiyi.principle.demeter.after.Principal principal = new com.baiyi.principle.demeter.after.Principal();
        Map<String, Object> queryClazzInfo = principal.queryClazzInfo("10001");
        logger.info("查询班级信息为：{}", JSON.toJSONString(queryClazzInfo));
    }

}
