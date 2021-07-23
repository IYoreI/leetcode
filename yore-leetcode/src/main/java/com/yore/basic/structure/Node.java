package com.yore.basic.structure;

/**
 * @author jia bing wen
 * @date 2021/7/22 10:28
 * @description 双向链接节点定义
 */
public class Node<T> {
    private T value;
    private Node<T> last;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
