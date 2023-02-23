package com.baiyi.principle.demeter.before;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 老师类
 * @author: BaiYi
 * @date: 2023/2/23 14:35
 */
public class Teacher {
    /** 老师姓名 */
    private String name;
    /** 班级 */
    private String clazz;
    /** 学生人数 */
    private static List<Student> studentList;

    public Teacher() {
    }

    public Teacher(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student("花花", 10, 589));
        studentList.add(new Student("豆豆", 54, 356));
        studentList.add(new Student("秋雅", 13, 439));
        studentList.add(new Student("皮皮", 2, 665));
        studentList.add(new Student("蛋蛋", 19, 502));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
