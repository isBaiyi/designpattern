package com.baiyi.principle;

import com.baiyi.principle.openclose.ICalculationArea;
import com.baiyi.principle.openclose.impl.CalculationArea;
import com.baiyi.principle.openclose.impl.CalculationAreaExt;
import org.junit.jupiter.api.Test;

/**
 * @description: 开闭原则测试
 * @author: BaiYi
 * @date: 2023/2/22 17:16
 */
class OpenCloseResponsibility {

    /**
     * 用于测试:
     */
    @Test
    void test_before() {
        ICalculationArea calculationArea = new CalculationArea();
        double circular = calculationArea.circular(10);
        System.out.println("circular = " + circular);
        // 如果自己觉得通用的SDK不符合自己的要求，可以自己继承实现扩展
        calculationArea = new CalculationAreaExt();
        circular = calculationArea.circular(10);
        System.out.println("circularExt = " + circular);

    }
}
