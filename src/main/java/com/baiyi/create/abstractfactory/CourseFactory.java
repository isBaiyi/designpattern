package com.baiyi.create.abstractfactory;

/**
 * @description:
 * @author: BaiYi
 * @date: 2023/3/5 21:24
 */
public abstract class CourseFactory {

    public void init() {
        System.out.println("初始化基础数据");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();
}
