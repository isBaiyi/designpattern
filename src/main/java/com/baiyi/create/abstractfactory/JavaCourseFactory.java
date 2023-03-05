package com.baiyi.create.abstractfactory;

/**
 * @description:
 * @author: BaiYi
 * @date: 2023/3/5 21:28
 */
public class JavaCourseFactory extends CourseFactory{
    @Override
    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
