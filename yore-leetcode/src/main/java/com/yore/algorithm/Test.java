package com.yore.algorithm;

/**
 * @author jia bing wen
 * @date 2021/4/19 15:26
 * @description
 */
public class Test {
    public static void main(String[] args) {

    }


    /**
     *  返回容量为rest的背包所能装的最大价值
     * @param weights
     * @param values
     * @param rest
     * @return
     */
    public int process1(int[] weights,int[] values,int rest){
        if(rest<0){
            return -1;
        }
        if(rest == 0){
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<weights.length;i++){
            int sub = process1(weights,values,rest-weights[i]);
            if(sub == -1){
                continue;
            }
            maxValue = Math.max(maxValue,sub + values[i]);
        }
        return maxValue == Integer.MIN_VALUE ? -1: maxValue;
    }




}
