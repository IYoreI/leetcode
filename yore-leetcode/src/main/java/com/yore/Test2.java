package com.yore;

/**
 * @author Yore
 * @date 2022/5/20 10:16
 * @description
 */
public class Test2 {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);
        SuperClass[] sca = new SuperClass[10];
    }
}

class SuperClass{
    static{
        System.out.println("SuperClass init");
    }
    public static int value = 123;
}

class SubClass extends SuperClass{
    static{
        System.out.println("SubClass init");
    }
}