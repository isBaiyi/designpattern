package com.baiyi.create.singleton.hungry;

/**
 * @description: 饿汉式单例模式
 * 优点：执行效率高，性能高，没有任何锁
 * 缺点：某些情况下，可能会造成内存浪费
 * @author: BaiYi
 * @date: 2023/3/5 22:05
 */
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
