package com.baiyi.create.abstractfactory;

/**
 * @description:
 * @author: BaiYi
 * @date: 2023/3/5 21:25
 */
public class PythonVideo implements IVideo{
    @Override
    public void record() {
        System.out.println("录制 Python 课程视频");
    }
}
