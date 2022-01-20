package com.yore.offer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yore
 * @date 2022/1/19 15:32
 * @description
 */
public class Offer086 {
    public static void main(String[] args) {
        Offer086 o = new Offer086();
        String[][] result = o.partition("abbab");
        for (String[] r : result) {
            System.out.print("[");
            for (String s : r) {
                System.out.print(s + ",");
            }
            System.out.print("]");
        }
    }

    public List<List<String>> res = new ArrayList<>();

    public String[][] partition(String s) {
        process(s, 0, new ArrayList<>());
        String[][] result = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).toArray(new String[0]);
        }
        return result;
    }

    public void process(String s, int index, List<String> list) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(String.valueOf(s.charAt(index)));
        print(index);
        System.out.println(list);
        process(s, index + 1, list);
        list.remove(list.size() - 1);

        int left = index - 1;
        int right = index + 1;
        Stack<String> st = new Stack<>();
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            st.push(list.remove(list.size() - 1));
            list.add(s.substring(left--, ++right));
            process(s, right, list);
            list.remove(list.size() - 1);
        }
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        left = index;
        right = index + 1;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            if (left < index) {
                st.push(list.remove(list.size() - 1));
            }
            list.add(s.substring(left--, ++right));
            process(s, right, list);
            list.remove(list.size() - 1);
        }
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
    }

    public void print(int idx) {
        for (int i = 0; i < idx; i++) {
            System.out.print(" ");
        }
    }

    /**
     * 一个字符串的所有回文子串
     *
     * @param s
     * @return
     */
    public List<String> palindrome(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            res.add(String.valueOf(s.charAt(i)));
            res.addAll(process(s, i));
        }
        return res;
    }

    public List<String> process(String s, int index) {
        List<String> list = new ArrayList<>();
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            list.add(s.substring(left--, ++right));
        }
        left = index;
        right = index + 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            list.add(s.substring(left--, ++right));
        }
        return list;
    }
}
