package com.yore.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/1/27
 * 自除数
 *
 * @author jiabingwen
 */

public class Number728 {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }

    public static List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        int tmp = 0;
        int every;
        for (int data = left; data <= right; data++) {
            flag = true;
            every = data;
            while (every != 0) {
                tmp = every % 10;
                if (tmp == 0 || data % (tmp) != 0) {
                    flag = false;
                    break;
                }
                every/=10;
            }
            if (flag) {
                list.add(data);
            }
        }
        return list;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int n=left;n<=right;n++){
            int div = n;
            while(div!=0){
                int t = div % 10;
                if(t == 0 || n%t !=0){
                    break;
                }
                div /= 10;
            }
            if(div == 0){
                list.add(n);
            }

        }
        return list;
    }
}
