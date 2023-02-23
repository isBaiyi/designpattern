package com.baiyi.principle.demeter.after;

import com.baiyi.principle.demeter.before.Student;

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
    private static List<com.baiyi.principle.demeter.before.Student> studentList;

    public Teacher() {
    }

    public Teacher(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    static {
        studentList = new ArrayList<>();
        studentList.add(new com.baiyi.principle.demeter.before.Student("花花", 10, 589));
        studentList.add(new com.baiyi.principle.demeter.before.Student("豆豆", 54, 356));
        studentList.add(new com.baiyi.principle.demeter.before.Student("秋雅", 13, 439));
        studentList.add(new com.baiyi.principle.demeter.before.Student("皮皮", 2, 665));
        studentList.add(new com.baiyi.principle.demeter.before.Student("蛋蛋", 19, 502));
    }

    /**
     * 获取班级人数
     *
     * @return 班级人数
     */
    public int clazzStudentCount() {
        return studentList.size();
    }

    /**
     * 获取班级总分
     *
     * @return 班级总分
     */
    public double clazzTotalScore() {
        return studentList.stream().mapToDouble(Student::getGrade).sum();
    }

    /**
     * 获取班级平均分
     *
     * @return 班级平均分
     */
    public double clazzAverageScore() {
        return studentList.stream().mapToDouble(Student::getGrade).sum() / studentList.size();
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
