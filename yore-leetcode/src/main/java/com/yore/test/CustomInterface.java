package com.yore.test;

/**
 * @author Yore
 * @date 2022/5/30 16:20
 * @description
 */
public interface CustomInterface {

    void doSearch();
    default void print(){
        System.out.println(11111);
    }
}
