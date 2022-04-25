package com.yore.week;

import java.util.*;

/**
 * @author Yore
 * @date 2022/4/24 10:49
 * @description
 */
public class LeetCode20220424 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int key = 0;
        for (int[] num : nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : num) {
                set.add(n);
            }
            map.put(key++, set);
        }
        for (int num = 1; num <= 1000; num++) {
            int i = 0;
            for (; i < nums.length; i++) {
                if (!map.get(i).contains(num)) {
                    break;
                }
            }
            if (i == nums.length) {
                list.add(num);
            }
        }
        return list;
    }

    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        for(int[] circle : circles){
            int x= circle[0];
            int y = circle[1];
            int r = circle[2];
            set.add(x+"_"+y);
            int[] ra = new int[2*r+1];
            int[] rb = new int[2*r+1];
            int begin = -r;
            for(int i=0;i<ra.length;i++){
                ra[i] = begin;
                rb[i] = begin;
                begin++;
            }
            for(int offset_x : ra){
                for(int offset_y : rb){
                    int a = x+offset_x;
                    int b = y+offset_y;
                    if(distance(x,y,a,b)<=r){
                        set.add(a+"_"+b);
                    }
                }
            }

        }
        return set.size();
    }
    public double distance(int x,int y,int a,int b){
        return Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
    }
}
