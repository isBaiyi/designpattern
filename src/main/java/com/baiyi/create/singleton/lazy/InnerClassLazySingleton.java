package com.baiyi.create.singleton.lazy;

/**
 * @description: 静态内部类写法，利用 Java 特点
 * Java 扫描加载类规则：
 *      classpath：InnerClassLazySingleton.class
 *                 InnerClassLazySingleton&LazyHolder.class
 *      只有在调用 getInstance() 方法时才会去加载 InnerClassLazySingleton&LazyHolder.class
 * 优点：写法优雅，利用了 Java 本身语法特点，性能提高，避免了内存浪费
 * 缺点：能够被反射破坏
 * @author: BaiYi
 * @date: 2023/3/6 00:00
 */
public class InnerClassLazySingleton {

    private InnerClassLazySingleton() {
        // 用于防止反射破坏单例
        if (LazyHolder.INSTANCE != null) {
            throw new UnsupportedOperationException("不允许非法访问");
        }
    }

    private static InnerClassLazySingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final InnerClassLazySingleton INSTANCE = new InnerClassLazySingleton();
    }

}
