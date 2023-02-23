package com.baiyi.principle;

import com.baiyi.principle.interfacesegregation.before.HeroHouYi;
import com.baiyi.principle.interfacesegregation.before.HeroLianPo;
import org.junit.jupiter.api.Test;

/**
 * @description: 接口隔离原则单元测试
 * @author: BaiYi
 * @date: 2023/2/23 15:26
 */
class InterfaceSegregationTest {

    /**
     * 用于测试: 未使用接口隔离原则
     * 每个英雄的实现类里都有一个和自己无关的接口实现类，非常不符合设计模式，也不易于维护。
     * 因为不仅无法控制外部的调用，还需要维护对应的文档，来说明这个接口不需要实现。如果有更多这样的接口，就会变得非常麻烦。
     */
    @Test
    void test_before() {
        HeroHouYi heroHouYi = new HeroHouYi();
        heroHouYi.doArchery();
        heroHouYi.doInvisible();
        heroHouYi.doSilent();
        heroHouYi.doVertigo();

        System.out.println("================");

        HeroLianPo heroLianPo = new HeroLianPo();
        heroLianPo.doArchery();
        heroLianPo.doInvisible();
        heroLianPo.doSilent();
        heroLianPo.doVertigo();
    }

    /**
     * 用于测试: 使用接口隔离原则
     * 现在可以看到这两个英雄的类都按需实现了自己需要的技能接口。
     * 这样的实现方式就可以避免一些本身不属于自己的技能还需要不断地用文档的方式进行维护，同时提高了代码的可靠性，在别人接手或者修改时，
     * 可以降低开发成本和维护风险。
     */
    @Test
    void test_after() {
        com.baiyi.principle.interfacesegregation.after.HeroHouYi heroHouYi =
                new com.baiyi.principle.interfacesegregation.after.HeroHouYi();
        heroHouYi.doArchery();
        heroHouYi.doInvisible();
        heroHouYi.doSilent();
        System.out.println("=====================");
        com.baiyi.principle.interfacesegregation.after.HeroLianPo heroLianPo =
                new com.baiyi.principle.interfacesegregation.after.HeroLianPo();
        heroLianPo.doInvisible();
        heroLianPo.doSilent();
        heroLianPo.doVertigo();
    }
}
