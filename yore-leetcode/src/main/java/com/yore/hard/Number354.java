package com.yore.hard;

/**
 * @author yore
 * @date 2021/3/4 9:40
 * @description
 */
public class Number354 {

    public static void main(String[] args) {
//        int[][] env = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};

        int[][] env = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println(maxEnvelopes(env));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        int tmp;
        if (length <= 0) {
            return 0;
        }
        //先按宽度从小到大排序
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (envelopes[i][0] > envelopes[j][0]) {
                    tmp = envelopes[i][0];
                    envelopes[i][0] = envelopes[j][0];
                    envelopes[j][0] = tmp;

                    tmp = envelopes[i][1];
                    envelopes[i][1] = envelopes[j][1];
                    envelopes[j][1] = tmp;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (envelopes[i][0] == envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    tmp = envelopes[i][0];
                    envelopes[i][0] = envelopes[j][0];
                    envelopes[j][0] = tmp;

                    tmp = envelopes[i][1];
                    envelopes[i][1] = envelopes[j][1];
                    envelopes[j][1] = tmp;
                }
            }
        }

        for (int[] envelope : envelopes) {
            System.out.println("[" + envelope[0] + "-" + envelope[1] + "]");
        }
        int count = 1;
        int width = envelopes[0][0];
        int height = envelopes[0][1];
        for (int i = 1; i < length; i++) {
            if (envelopes[i][0] > width && envelopes[i][1] > height) {
                count++;
                width = envelopes[i][0];
                height = envelopes[i][1];
            }
        }
        return count;
    }

}
