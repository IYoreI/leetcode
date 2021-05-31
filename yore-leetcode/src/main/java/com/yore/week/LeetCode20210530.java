package com.yore.week;


/**
 * @author jia bing wen
 * @date 2021/5/30 10:04
 * @description
 */
public class LeetCode20210530 {


    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int num1 = Integer.parseInt(convert(firstWord));
        int num2 = Integer.parseInt(convert(secondWord));
        int num3 = Integer.parseInt(convert(targetWord));
        return (num1 + num2) == num3;
    }

    public String convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a');
        }
        return sb.toString();
    }


    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        if (n.charAt(0) == '-') {
            int index = 1;
            while (index < n.length()) {
                int current = n.charAt(index) - '0';
                if (current > x) {
                    sb.insert(index, x);
                    break;
                }
                index++;
            }
            if (index == n.length()) {
                sb.insert(index, x);
            }
        } else {
            int index = 0;
            while (index < n.length()) {
                int current = n.charAt(index) - '0';
                if (current < x) {
                    sb.insert(index, x);
                    break;
                }
                index++;
            }
            if (index == n.length()) {
                sb.insert(index, x);
            }
        }
        return sb.toString();
    }


    int skip = 0;
    int total = 0;
    int speed;

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        speed = speed;

        Stat stat = new Stat(0, 0);


        return -1;
    }

    public int dfs(int[] dist, int index, Stat stat) {
        if (index >= dist.length) {
            return -1;
        }
        double cost = (double) dist[index] / speed;
        double diff = Math.ceil(cost) - cost;


        if (Math.ceil(stat.getHours()) - stat.getHours() == 0) {
            stat = new Stat(stat.hours, stat.skip);
        } else {
            stat = new Stat(stat.hours, stat.skip + 1);
        }

        dfs(dist, index + 1, stat);
    }


    class Stat {
        double hours;
        int skip;

        public Stat() {

        }

        public Stat(double hours, int skip) {
            this.hours = hours;
            this.skip = skip;
        }

        public double getHours() {
            return hours;
        }

        public void setHours(double hours) {
            this.hours = hours;
        }

        public int getSkip() {
            return skip;
        }

        public void setSkip(int skip) {
            this.skip = skip;
        }
    }

    public static void main(String[] args) {
        System.out.println((double) 7 / 2);
        System.out.println(Math.floor(3.5));
        System.out.println(Math.ceil(3.5));
    }

}
