package com.baiyi.create.factorymethod.after;

import java.util.Map;

/**
 * @description: 发放商品接口
 * @author: BaiYi
 * @date: 2023/2/24 21:10
 */
public interface ICommodity {

    /**
     * 发放商品接口
     *
     * @param uId         用户ID
     * @param commodityId 商品ID
     * @param bizId       业务ID
     * @param extMap      扩展参数
     * @throws Exception 异常信息
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
