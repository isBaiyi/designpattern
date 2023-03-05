package com.baiyi.create.abstractfactory;

/**
 * @description:
 * @author: BaiYi
 * @date: 2023/3/5 21:28
 */
public class PythonCourseFactory extends CourseFactory{
    @Override
    public INote createNote() {
        super.init();
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
