package com.yore.offer2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/23 17:16
 * @description
 */
public class Offer111 {

    public static void main(String[] args) {
        List list = new LinkedList<>();
        while (true) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }
}
