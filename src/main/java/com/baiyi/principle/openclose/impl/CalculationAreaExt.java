package com.baiyi.principle.openclose.impl;

/**
 * @description: 扩展继承，实现自己的需求
 * @author: BaiYi
 * @date: 2023/2/22 17:20
 */
public class CalculationAreaExt extends CalculationArea {
    private static final double π = 3.141592653D;

    @Override
    public double circular(double r) {
        return π * r * r;
    }
}
