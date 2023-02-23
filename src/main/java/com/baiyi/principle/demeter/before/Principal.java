package com.baiyi.principle.demeter.before;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 校长类
 * @author: BaiYi
 * @date: 2023/2/23 14:39
 */
public class Principal {
    private Teacher teacher = new Teacher("丽华", "三年一班");

    /**
     * 查询班级信息：总分、学生人数、平均分
     *
     * @param clazzId 班级ID
     * @return 班级信息
     */
    public Map<String, Object> queryClazzInfo(String clazzId) {
        // 获取班级信息：学生人数、总分、平均分
        int stuCount = clazzStudentCount();
        double totalScore = clazzTotalScore();
        double averageScore = totalScore / stuCount;
        // 组装对象，实际业务开发会有对应的类
        HashMap<String, Object> data = new HashMap<>();
        data.put("班级", teacher.getClazz());
        data.put("老师姓名", teacher.getName());
        data.put("学生人数", stuCount);
        data.put("总分", totalScore);
        data.put("平均分", averageScore);
        return data;
    }

    /**
     * 获取班级总分
     *
     * @return 班级总分
     */
    private double clazzTotalScore() {
        double totalScore = 0;
        for (Student student : teacher.getStudentList()) {
            totalScore += student.getGrade();
        }
        return totalScore;
    }

    /**
     * 获取班级人数
     *
     * @return 班级人数
     */
    private int clazzStudentCount() {
        return teacher.getStudentList().size();
    }
}
