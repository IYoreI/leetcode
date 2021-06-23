package com.yore.offer;

/**
 * @author jia bing wen
 * @date 2021/6/23 10:15
 * @description
 */
public class Offer14_2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) (((long) Math.pow(3, quotient)) % 1000000007);
        } else if (remainder == 1) {
            return (int) (((long) Math.pow(3, quotient - 1) * 4) % 1000000007);
        } else {
            return (int) (((long) Math.pow(3, quotient) * 2) % 1000000007);
        }
    }

    public static void main(String[] args) {
        Offer14_2 o = new Offer14_2();
        System.out.println(o.cuttingRope(100));
    }
}
