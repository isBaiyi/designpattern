package com.baiyi.create.singleton.lazy;

/**
 * @description: 懒汉式简单写法
 * 优点：节省内存
 * 缺点：线程不安全
 * @author: BaiYi
 * @date: 2023/3/5 22:14
 */
public class LazySimpleSingleton {
    public static LazySimpleSingleton INSTANCE = null;

    private LazySimpleSingleton() {
    }

    public static LazySimpleSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE =  new LazySimpleSingleton();
        }
        return INSTANCE;
    }
}
