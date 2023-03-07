package com.baiyi.create.singleton.threadlocal;

/**
 * @description: thread local 实现单例模式
 * @author: BaiYi
 * @date: 2023/3/7 21:54
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> INSTANCE = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    private ThreadLocalSingleton() {}

    public static ThreadLocalSingleton getInstance() {
        return INSTANCE.get();
    }

    @Override
    protected void finalize() throws Throwable {
        INSTANCE.remove();
    }
}
