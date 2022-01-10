package com.yore.graph;

import java.util.*;

/**
 * @author Yore
 * @date 2022/1/10 14:47
 * @description 图的广度优先遍历和深度优先遍历
 */
public class GraphIteration {


    public void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node n : cur.nexts) {
                if (!set.contains(n)) {
                    queue.add(n);
                    set.add(n);
                }
            }
        }
    }


    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        Set<Node> set = new HashSet<>();
        st.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!st.isEmpty()) {
            Node cur = st.pop();
            for (Node n : node.nexts) {
                if (!set.contains(n)) {
                    st.push(cur);
                    st.push(n);
                    set.add(n);
                    System.out.println(n.value);
                    break;
                }
            }
        }
    }
}
