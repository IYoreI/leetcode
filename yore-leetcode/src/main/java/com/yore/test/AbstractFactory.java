package com.yore.test;

/**
 * @author Yore
 * @date 2022/5/30 16:24
 * @description
 */
public abstract class AbstractFactory {
    private int a = 10;

    public void create() {
        System.out.println("create ..."+a);
    }

    protected abstract void delete();

}
