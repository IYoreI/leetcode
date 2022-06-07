package com.yore;

import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * @author Yore
 * @date 2022/3/8 9:27
 * @description
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        short a = 127 + 60;
        short b = 127;
        a = (short) (a + b);
        System.out.println(a);
        System.out.println(0.1 + 0.2);
    }

    public static long byteArrayToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();
        return buffer.getLong();
    }


}

class Points {
    int x;
    int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return x == points.x &&
                y == points.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void fun(int a) {

    }

    public void fun(int a, int b) {

    }

    public void fun(Integer a) {

    }
}


