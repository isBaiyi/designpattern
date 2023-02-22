package com.baiyi.principle.single.after.impl;

import com.baiyi.principle.single.after.IVideoUserService;

/**
 * @description: 访客用户
 * @author: BaiYi
 * @date: 2023/2/22 17:06
 */
public class GuestVideoUserService implements IVideoUserService {

    @Override
    public void definition() {
        System.out.println("访客用户，视频480P高清");
    }

    @Override
    public void advertisement() {
        System.out.println("访客用户，视频有广告");
    }
}
