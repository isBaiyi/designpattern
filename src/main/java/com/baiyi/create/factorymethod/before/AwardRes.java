package com.baiyi.create.factorymethod.before;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 抽奖返回结果
 * @author: BaiYi
 * @date: 2023/2/24 14:44
 */
@Data
@AllArgsConstructor
public class AwardRes {
    private String code; // 编码
    private String info; // 描述
}
