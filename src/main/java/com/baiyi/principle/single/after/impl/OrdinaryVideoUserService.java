package com.baiyi.principle.single.after.impl;

import com.baiyi.principle.single.after.IVideoUserService;

/**
 * @description: 普通用户
 * @author: BaiYi
 * @date: 2023/2/22 17:07
 */
public class OrdinaryVideoUserService implements IVideoUserService {

    @Override
    public void definition() {
        System.out.println("普通用户，视频720P超清");
    }

    @Override
    public void advertisement() {
        System.out.println("普通用户，视频有广告");
    }
}
