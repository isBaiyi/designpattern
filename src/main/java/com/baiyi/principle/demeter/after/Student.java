package com.baiyi.principle.demeter.after;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 学生
 * @author: BaiYi
 * @date: 2023/2/23 14:33
 */
@Data
@AllArgsConstructor
public class Student {
    /** 姓名 */
    private String name;
    /** 考试排名（总排名） */
    private int rank;
    /**  总成绩 */
    private double grade;
}
