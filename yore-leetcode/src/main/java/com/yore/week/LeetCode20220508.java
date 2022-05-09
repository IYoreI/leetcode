package com.yore.week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yore
 * @date 2022/5/8 9:59
 * @description
 */
public class LeetCode20220508 {

    public static void main(String[] args) {
        LeetCode20220508 l = new LeetCode20220508();
//        System.out.println(l.countTexts("22233"));
        System.out.println(l.largestGoodInteger("222"));
    }

    public String largestGoodInteger(String num) {
        Set<String> numSet = new HashSet<>();
        int n = num.length();
        if(n<3){
            return "";
        }
        int cnt = 1;
        for(int index=1;index<n;index++){
            if(cnt==3){
                numSet.add(num.substring(index-3,index));
                cnt = 0;
            }
            if(num.charAt(index) == num.charAt(index-1)){
                cnt++;
            }else{
                cnt =1;
            }
        }
        if(cnt == 3){
            numSet.add(num.substring(n-3,n));
        }
        int max=0;
        String res ="";
        for(String s : numSet){
            if(Integer.valueOf(s)>=max){
                max = Integer.valueOf(s);
                res = s;
            }
        }
        return res;
    }



    int cnt = 0;
    Map<String, Integer> countMap = new HashMap<>();
    int mod = 1000000007;
    long res = 1L;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int begin = 0;
        long res = 1L;
        for (int i = 1; i < n; i++) {
            if (pressedKeys.charAt(i) != pressedKeys.charAt(begin)) {
                String s = pressedKeys.substring(begin, i);
                begin = i;
                int limit = 3;
                cnt = 0;
                if (s.charAt(0) == '7' || s.charAt(0) == '9') {
                    limit = 4;
                }
                dfs(s, s.length(), 0, limit, new StringBuilder(""));
                res = (res * (cnt % mod)) % mod;
            }
        }
        String s = pressedKeys.substring(begin, n);
        int limit = 3;
        cnt = 0;
        if (s.charAt(0) == '7' || s.charAt(0) == '9') {
            limit = 4;
        }
        dfs(s, s.length(), 0, limit, new StringBuilder(""));
        res = (res * (cnt % mod)) % mod;

        return (int) res;
    }



    public void dfs(String keys, int n, int idx, int limit, StringBuilder sb) {
        if (sb.length() == n) {
            cnt++;
            return;
        }
        String rest = keys.substring(idx, n);
        if (countMap.containsKey(rest)) {
            cnt = (cnt + countMap.get(rest)) % mod;
            return;
        }
        int end = Math.min(n, idx + limit);
        for (int j = idx + 1; j <= end; j++) {
            sb.append(keys, idx, j);
            dfs(keys, n, j, limit, sb);
            sb.delete(idx, sb.length());
        }
        countMap.put(rest, cnt % mod);
    }
}
