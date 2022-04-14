package com.yore.graph;

import java.util.*;

/**
 * @author Yore
 * @date 2022/1/10 14:47
 * @description 图的广度优先遍历和深度优先遍历 以及拓扑排序
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

    /**
     * 图的拓扑排序  必须是有向无环图
     * 每次找入度为0的点，入队列，并删除跟其有关联的边，更新其他节点的入度，一直循环
     * @param graph
     * @return
     */
    public List<Node> sortTopology(Graph graph) {
        List<Node> result = new ArrayList<>();
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in == 0){
                zeroInQueue.offer(node);
            }
        }
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next,inMap.get(next)-1);
                if(inMap.get(next) == 0){
                    zeroInQueue.offer(next);
                }
            }
        }
        return result;
    }

}
