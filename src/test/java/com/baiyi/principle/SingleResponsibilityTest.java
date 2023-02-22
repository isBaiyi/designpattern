package com.baiyi.principle;

import com.baiyi.principle.single.after.IVideoUserService;
import com.baiyi.principle.single.after.impl.GuestVideoUserService;
import com.baiyi.principle.single.after.impl.OrdinaryVideoUserService;
import com.baiyi.principle.single.after.impl.VipVideoUserService;
import com.baiyi.principle.single.before.VideoUserService;
import org.junit.jupiter.api.Test;

/**
 * @description: 单一职责原则测试类
 * @author: BaiYi
 * @date: 2023/2/22 17:02
 */
class SingleResponsibilityTest {

    /**
     * 用于测试: 未使用设计模式
     */
    @Test
    void test_before() {
        VideoUserService videoUserService = new VideoUserService();
        videoUserService.serveGrade("VIP用户");
        videoUserService.serveGrade("普通用户");
        videoUserService.serveGrade("访客用户");
    }

    @Test
    void test_after() {
        IVideoUserService guest = new GuestVideoUserService();
        IVideoUserService ordinary = new OrdinaryVideoUserService();
        IVideoUserService vip = new VipVideoUserService();
        guest.definition();
        guest.advertisement();
        System.out.println("=======");
        ordinary.definition();
        ordinary.advertisement();
        System.out.println("=======");
        vip.definition();
        vip.advertisement();
    }
}
