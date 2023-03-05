package com.baiyi.create.abstractfactory;

/**
 * @description:
 * @author: BaiYi
 * @date: 2023/3/5 21:27
 */
public class PythonNote implements INote{
    @Override
    public void edit() {
        System.out.println("编写 Python 笔记");
    }
}
