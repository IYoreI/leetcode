package com.yore.test;

/**
 * @author Yore
 * @date 2022/5/30 16:26
 * @description
 */
public class ChildFactory extends AbstractFactory {
    @Override
    public void delete() {
        create();
        System.out.println("delete");
    }


}
