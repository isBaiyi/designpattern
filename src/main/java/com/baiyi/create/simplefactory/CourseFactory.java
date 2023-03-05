package com.baiyi.create.simplefactory;

/**
 * @description:
 * @author: BaiYi
 * @date: 2023/3/5 20:28
 */
public class CourseFactory {
    /**
     * 方式一：创建课程
     *
     * @param className 课程类型
     * @return 课程
     */
    public ICourse createCourse(String className) {
        if ("java".equals(className)) {
            return new JavaCourse();
        } else if ("python".equals(className)) {
            return new PythonCourse();
        } else {
            throw new UnsupportedOperationException("未支持当前课程");
        }
    }

    /**
     * 根据反射创建课程
     *
     * @param clazz class类
     * @return 课程
     */
    public ICourse createCourseByReflect(Class<? extends ICourse> clazz) {
        try {
            return ((ICourse) clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException("未支持当前课程");
        }
    }
}
