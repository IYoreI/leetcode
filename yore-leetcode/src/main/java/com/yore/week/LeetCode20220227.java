package com.yore.week;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/2/27 10:18
 * @description
 */
public class LeetCode20220227 {
    public static void main(String[] args) {
        LeetCode20220227 l = new LeetCode20220227();
        System.out.println(l.minimumTime(new int[]{10000}, 10000000));
    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(pref)) {
                count++;
            }
        }
        return count;
    }


    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        int n = time.length;
        long left = time[0];
        long right = time[0] * totalTrips;
        while (left < right) {
            long mid = left + (right-left) / 2;
            long  t = 0L;
            for(int i=0;i<n;i++){
                t += (mid / time[i]);
            }
            if(t >= totalTrips){
                right = mid;
            }else if(t < totalTrips){
                left = mid + 1;
            }
        }
        return right;
    }

}
