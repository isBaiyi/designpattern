package com.baiyi.principle.single.after.impl;

import com.baiyi.principle.single.after.IVideoUserService;

/**
 * @description: VIP用户
 * @author: BaiYi
 * @date: 2023/2/22 17:08
 */
public class VipVideoUserService implements IVideoUserService {

    @Override
    public void definition() {
        System.out.println("VIP用户，视频1080P蓝光");
    }

    @Override
    public void advertisement() {
        System.out.println("VIP用户，视频无广告");
    }
}
