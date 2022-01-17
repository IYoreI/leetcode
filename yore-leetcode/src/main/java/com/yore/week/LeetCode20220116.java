package com.yore.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/16 10:30
 * @description
 */
public class LeetCode20220116 {
    public static void main(String[] args) {
        LeetCode20220116 L = new LeetCode20220116();
//        String[] res = L.divideString("a", 3, 'X');
//        for (String s : res) {
//            System.out.println(s);
//        }

//        System.out.println(L.minMoves(19, 2));
//        System.out.println(L.minMoves(766972377, 92));

        int[][] q = new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(L.mostPoints2(q));
        ;


    }

    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();
        int index = 0;
        int len = s.length();
        while (index < len) {
            if (index + k < len) {
                list.add(s.substring(index, index + k));
                index += k;
            } else {
                break;
            }

        }
        StringBuilder sb = new StringBuilder("");
        sb.append(s.substring(index, len));
        int remain = k - len + index;
        while (remain > 0) {
            sb.append(fill);
            remain--;
        }
        list.add(sb.toString());
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int minMoves_1(int target, int maxDoubles) {
        int count = 0;
        while (target != 1) {
            if(maxDoubles == 0){
                break;
            }else if(target % 2 == 0 ){
                target /= 2;
                maxDoubles--;
            } else {
                target -= 1;
            }
            count++;
        }
        return count + (target - 1);
    }

    public int minMoves(int target, int maxDoubles) {
        return process(target, maxDoubles, 1);
    }

    public int process(int target, int rest, int cur) {
        if (cur == target) {
            return 0;
        }
        if (cur > target) {
            return -1;
        }
        int res = 0;
        int f1 = process(target, rest, cur + 1);
        int f2 = f1;
        if (rest > 0) {
            f2 = process(target, rest - 1, cur * 2);
        }
        if (f2 != -1) {
            res = Math.min(f1, f2);
        } else {
            res = f1;
        }
        return res + 1;
    }



    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[]record = new long[len];
        for(int i =0;i<len;i++){
            record[i]=-1L;
        }
        return process(questions, len, 0,record);
    }

    public long process(int[][] questions, int len, int index,long[] record) {
        if (index >= len) {
            return 0;
        }
        if(record[index]!=-1){
            return record[index];
        }
        int skip = questions[index][1];
        record[index] = Math.max(questions[index][0] + process(questions, len, index + skip + 1,record),
                process(questions, len, index + 1,record));
        return record[index];
    }


    public long mostPoints2(int[][] questions) {
        int len = questions.length;
        int[] dp = new int[len];
//        dp[len] = 0;
        for(int i=0;i<len;i++){
            dp[i] = questions[i][0];
        }
        for (int i = len - 2; i >= 0; i--) {
            int skip = questions[i][1];
            dp[i] = Math.max(dp[i],dp[i + 1]);
            if (i + skip + 1 < len) {
                dp[i] = Math.max(dp[i], dp[i + skip + 1] + questions[i][0]);
            }
        }
        return dp[0];
    }

}
