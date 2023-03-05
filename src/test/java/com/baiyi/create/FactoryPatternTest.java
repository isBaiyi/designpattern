package com.baiyi.create;

import com.baiyi.create.abstractfactory.JavaCourseFactory;
import com.baiyi.create.abstractfactory.PythonCourseFactory;
import com.baiyi.create.simplefactory.CourseFactory;
import com.baiyi.create.simplefactory.PythonCourse;
import org.junit.jupiter.api.Test;

/**
 * @description: 工厂模式相关单元测试
 * @author: BaiYi
 * @date: 2023/3/5 20:22
 */
class FactoryPatternTest {

    /**
     * 用于测试: 使用简单工厂方法进行实现课程录制
     * 简单工厂适用于创建的对象较少
     */
    @Test
    void test_simple_factory_record_course() {
        CourseFactory courseFactory = new CourseFactory();
        courseFactory.createCourse("java").record();
        courseFactory.createCourseByReflect(PythonCourse.class).record();

        // JDK 源码 Calendar.getInstance() 方法
        // LoggerFactory.getLogger() 方法
    }

    /**
     * 用于测试: 抽象工厂
     */
    @Test
    void test_abstract_factory() {
        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createVideo().record();
        javaCourseFactory.createNote().edit();

        PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
        pythonCourseFactory.createVideo().record();
        pythonCourseFactory.createNote().edit();

    }
}
