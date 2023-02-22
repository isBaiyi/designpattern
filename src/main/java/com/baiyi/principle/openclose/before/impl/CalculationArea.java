package com.baiyi.principle.openclose.before.impl;

import com.baiyi.principle.openclose.before.ICalculationArea;

/**
 * @description: 面积计算实现
 * @author: BaiYi
 * @date: 2023/2/22 17:18
 */
public class CalculationArea implements ICalculationArea {

    private static final double π = 3.14D;

    public double rectangle(double x, double y) {
        return x * y;
    }

    public double triangle(double x, double y, double z) {
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    public double circular(double r) {
        return π * r * r;
    }
}
