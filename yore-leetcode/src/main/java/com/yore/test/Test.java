package com.yore.test;

/**
 * @author Yore
 * @date 2022/5/30 16:22
 * @description
 */
public class Test {
    public static void main(String[] args) {
//        CustomInterface c = new CustomImpl();
//        c.doSearch();
//        c.print();
//
//        AbstractFactory af = new ChildFactory();
//        af.delete();
//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println(s1==s2);//true
//        System.out.println(s1.equals(s2));//true
//
//        String s3 = new String("100");
//        String s4 = new String("100");
//        System.out.println(s3==s4);//false
//        System.out.println(s3.equals(s4));//true

        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str2.intern() == str2);
    }
}
