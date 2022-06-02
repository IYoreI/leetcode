package com.yore.test;

import java.util.Objects;

/**
 * @author Yore
 * @date 2022/5/30 16:55
 * @description
 */
public class Main {
    private int a;
    public String c;
    CustomImpl s;

    public Main(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return a == main.a &&
                Objects.equals(c, main.c) &&
                Objects.equals(s, main.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, c, s);
    }
}
