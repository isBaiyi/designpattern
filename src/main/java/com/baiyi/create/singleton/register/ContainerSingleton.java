package com.baiyi.create.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 容器式单例
 * @author: BaiYi
 * @date: 2023/3/7 21:37
 */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        if (!ioc.containsKey(className)) {
            try {
                Object instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ioc.get(className);
    }
}
