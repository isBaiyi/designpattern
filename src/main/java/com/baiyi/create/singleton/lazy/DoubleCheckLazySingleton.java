package com.baiyi.create.singleton.lazy;

/**
 * @description: 双重检查锁实现懒加载单例模式
 * 优点：性能提高，线程也安全
 * 缺点：可读性难度加大，不够优雅
 * @author: BaiYi
 * @date: 2023/3/5 23:46
 */
public class DoubleCheckLazySingleton {

    // volatile 解决指令重排序问题，加上 volatile 关键字会通知其他线程进行更新本地内存
    private static volatile DoubleCheckLazySingleton INSTANCE = null;

    private DoubleCheckLazySingleton() {
    }

    public static DoubleCheckLazySingleton getInstance() {
        // 检查是否需要阻塞
        if (null == INSTANCE) {
            synchronized (DoubleCheckLazySingleton.class) {
                // 检查是否需要重新创建实例
                if (null == INSTANCE) {
                    INSTANCE = new DoubleCheckLazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
