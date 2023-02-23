package com.baiyi.principle.demeter.after;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 校长类
 * @author: BaiYi
 * @date: 2023/2/23 14:39
 */
public class Principal {
    private com.baiyi.principle.demeter.after.Teacher teacher = new Teacher("丽华", "三年一班");

    /**
     * 查询班级信息：总分、学生人数、平均分
     *
     * @param clazzId 班级ID
     * @return 班级信息
     */
    public Map<String, Object> queryClazzInfo(String clazzId) {
        // 获取班级信息：学生人数、总分、平均分
        HashMap<String, Object> data = new HashMap<>();
        data.put("班级", teacher.getClazz());
        data.put("老师姓名", teacher.getName());
        data.put("学生人数", teacher.clazzStudentCount());
        data.put("总分", teacher.clazzTotalScore());
        data.put("平均分", teacher.clazzAverageScore());
        return data;
    }

}
