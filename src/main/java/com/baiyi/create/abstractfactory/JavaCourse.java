package com.baiyi.create.abstractfactory;

/**
 * @description:
 * @author: BaiYi
 * @date: 2023/3/5 21:21
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制 Java 课程");
    }
}
