package com.baiyi.principle.interfacesegregation.after;

/**
 * @description: 王者荣耀英雄后裔
 * @author: BaiYi
 * @date: 2023/2/23 15:39
 */
public class HeroHouYi implements ISkillArchery, ISkillInvisible, ISkillSilent {
    @Override
    public void doArchery() {
        System.out.println("后裔的灼日之矢");
    }

    @Override
    public void doInvisible() {
        System.out.println("后裔的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("后裔的沉默技能");
    }
}
