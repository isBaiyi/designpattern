package com.baiyi.create.singleton.register;

/**
 * @description: 枚举方法实现单例模式
 * @author: BaiYi
 * @date: 2023/3/5 23:52
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
