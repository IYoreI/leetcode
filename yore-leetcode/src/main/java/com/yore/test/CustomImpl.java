package com.yore.test;

/**
 * @author Yore
 * @date 2022/5/30 16:21
 * @description
 */
public class CustomImpl implements CustomInterface{
    @Override
    public void doSearch() {
        System.out.println("doSearch");
    }

    @Override
    public void print() {
        System.out.println("222");
    }
}
