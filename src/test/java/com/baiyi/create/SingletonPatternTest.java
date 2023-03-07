package com.baiyi.create;

import com.baiyi.create.singleton.hungry.HungrySingleton;
import com.baiyi.create.singleton.hungry.HungryStaticSingleton;
import com.baiyi.create.singleton.lazy.DoubleCheckLazySingleton;
import com.baiyi.create.singleton.lazy.InnerClassLazySingleton;
import com.baiyi.create.singleton.lazy.LazySimpleSingleton;
import com.baiyi.create.singleton.register.ContainerSingleton;
import com.baiyi.create.singleton.register.EnumSingleton;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: 单例模式单元测试
 * @author: BaiYi
 * @date: 2023/3/5 22:18
 */
class SingletonPatternTest {

    /**
     * 用于测试: 饿汉式单例模式
     */
    @Test
    void test_hungary() {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        Assertions.assertEquals(hungrySingleton2, hungrySingleton1);

        HungryStaticSingleton hungryStaticSingleton1 = HungryStaticSingleton.getInstance();
        HungryStaticSingleton hungryStaticSingleton2 = HungryStaticSingleton.getInstance();
        Assertions.assertEquals(hungryStaticSingleton1, hungryStaticSingleton2);
    }


    /**
     * 用于测试: 懒加载单例模式简单写法，该写法线程不安全，可以通过 debug 方式进行测试
     * 运行结果：
     *  同一个实例
     *     1. 正常顺序执行
     *     2. 后者覆盖前者情况
     *  不同实例
     *      同时进入条件，按顺序返回
     */
    @Test
    void test_lazy_simple_singleton() {
        Thread t1 = new Thread(new ExecuteThread());
        Thread t2 = new Thread(new ExecuteThread());
        t1.start();
        t2.start();
        System.out.println("end");
    }

    /**
     * 执行线程池
     */
    static class ExecuteThread implements Runnable {
        @Override
        public void run() {
            LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + instance);
        }
    }

    /**
     * 用于测试: 双重检查锁实现单例模式
     */
    @Test
    void test_double_check_single() {
        Thread t1 = new Thread(new ExecuteThread());
        Thread t2 = new Thread(new ExecuteThread());
        t1.start();
        t2.start();
        System.out.println("end");

        DoubleCheckLazySingleton instance = DoubleCheckLazySingleton.getInstance();
        DoubleCheckLazySingleton instance1 = DoubleCheckLazySingleton.getInstance();
        Assertions.assertEquals(instance1, instance);
    }

    /**
     * 用于测试: 使用反射破坏单例模式
     */
    @Test
    void test_reflect() {
        Class<InnerClassLazySingleton> clazz = InnerClassLazySingleton.class;
        try {
                Constructor<InnerClassLazySingleton> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            InnerClassLazySingleton innerClassLazySingleton = constructor.newInstance();
            InnerClassLazySingleton innerClassLazySingleton1 = constructor.newInstance();
            System.out.println(innerClassLazySingleton);
            System.out.println(innerClassLazySingleton1);
            Assertions.assertNotEquals(innerClassLazySingleton1, innerClassLazySingleton);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用于测试: 枚举式单例
     */
    @Test
    void test_enum_singleton() {
        EnumSingleton instance = EnumSingleton.getInstance();
        EnumSingleton instance1 = EnumSingleton.getInstance();
        Assertions.assertEquals(instance1, instance);
    }

    /**
     * 用于测试: 容器式单例
     */
    @Test
    void test_container_singleton() {
        User instance = (User) ContainerSingleton.getInstance("com.baiyi.create.User");
        User instance1 = (User) ContainerSingleton.getInstance("com.baiyi.create.User");
        Assertions.assertEquals(instance1, instance);
    }
}
