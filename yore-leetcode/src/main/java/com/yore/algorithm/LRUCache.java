package com.yore.algorithm;

import com.yore.medium.Number146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yore
 * 哈希表加链表实现
 * @date 2021/12/29 14:48
 * @description
 */
public class LRUCache {
    private HashMap<Integer, Node> linkMap;
    private int current;
    private int capacity;

    private Node HEAD;  //头节点
    private Node TAIL;  //尾结点

    public LRUCache(int capacity) {
        this.linkMap = new HashMap<>(capacity + 2);
        this.current = 0;
        this.capacity = capacity;
        //初始化双向链表头尾节点
        HEAD = new Node(-1, -1);
        TAIL = new Node(10001, -1);
        HEAD.next = TAIL;
        TAIL.pre = HEAD;
        this.linkMap.put(-1, HEAD);
        this.linkMap.put(10001, TAIL);
    }

    public int get(int key) {
        if (linkMap.containsKey(key)) {
            //更新缓存策略，当前节点为最近访问节点
            Node node = linkMap.get(key);
            //从原位置中删除node
            removeOriginalNode(node);
            //添加node到队尾，代表最近访问
            addNodeToTail(node);
            return linkMap.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (linkMap.containsKey(key)) {
            linkMap.get(key).value = value;
            node = linkMap.get(key);
            //从原位置中删除node
            removeOriginalNode(node);
            //添加node到队尾，代表最近访问
            addNodeToTail(node);
        } else {
            node = new Node(key, value);
            if (current >= capacity) {
                // 删除最久元素
                Node removeNode = HEAD.next;
                HEAD.next = removeNode.next;
                removeNode.next.pre = HEAD;
                linkMap.remove(removeNode.key);
                this.current--;
            }
            addNodeToTail(node);
            this.linkMap.put(key, node);
            this.current++;
        }
    }

    public void removeOriginalNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addNodeToTail(Node node) {
        Node first = TAIL.pre;
        TAIL.pre = node;
        node.next = TAIL;
        first.next = node;
        node.pre = first;
    }

    class Node {
        private int key;
        private int value;
        private Node next;
        private Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }
}
