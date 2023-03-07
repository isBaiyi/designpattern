package com.baiyi.create.singleton.hungry;

/**
 * @description: 静态代码块饿汉式
 * @author: BaiYi
 * @date: 2023/3/5 22:06
 */
public class HungryStaticSingleton {
    /**
     * 类加载流程：先静态后动态；先上后下；先属性后方法
     */
    public static HungryStaticSingleton INSTANCE = null;

    private HungryStaticSingleton() {}

    static {
        INSTANCE = new HungryStaticSingleton();
    }

    public static HungryStaticSingleton getInstance() {
        return INSTANCE;
    }
}
