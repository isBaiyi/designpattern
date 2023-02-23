package com.baiyi.principle.interfacesegregation.before;

/**
 * @description: 王者荣耀英雄，廉颇
 * @author: BaiYi
 * @date: 2023/2/23 15:25
 */
public class HeroLianPo implements ISkill{

    @Override
    public void doArchery() {
        // 无此技能的实现
    }

    @Override
    public void doInvisible() {
        System.out.println("廉颇的隐身技能");
    }

    @Override
    public void doSilent() {
        System.out.println("廉颇的沉默技能");
    }

    @Override
    public void doVertigo() {
        System.out.println("廉颇的眩晕技能");
    }

}
