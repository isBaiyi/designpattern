package com.baiyi.visitor;

/**
 * @description:
 * @author: BaiYi
 * @date: 2022/10/17 22:25
 */
public class Hello {
    private String name;

    public void sayHello(String name) {
        String baiyi = "uncle";
        if (name.equals("baiyi")) {
            System.out.println(name);
        }

        System.out.println(baiyi);

    }
}
