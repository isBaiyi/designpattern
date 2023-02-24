package com.baiyi.create.factorymethod.base.card;

/**
 * @description: 模拟爱奇艺会员卡服务
 * @author: BaiYi
 * @date: 2023/2/24 14:36
 */
public class IQiYiCardService {

    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
    }

}
