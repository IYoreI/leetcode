package com.yore.graph;

import java.util.*;

/**
 * @author Yore
 * @date 2022/1/11 19:14
 * @description 最小生成树: k算法和p算法
 */
public class MST {

    public static class UnionFind {
        private Map<Node, Node> fatherMap;
        private Map<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node node) {
            Stack<Node> path = new Stack<>();
            while (node != fatherMap.get(node)) {
                path.push(node);
                node = fatherMap.get(node);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), node);
            }
            return node;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = fatherMap.get(a);
            Node bHead = fatherMap.get(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node big = aSetSize >= bSetSize ? aHead : bHead;
                Node small = big == aHead ? bHead : aHead;
                fatherMap.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }
    }

    public Set<Edge> kMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            edgeQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!edgeQueue.isEmpty()) {
            Edge edge = edgeQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }


    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    /**
     * 从一个点开始逐步扩散，每次选择关联边中权重最小的
     *
     * @param graph
     * @return
     */
    public Set<Edge> primMST(Graph graph) {
        Set<Edge> result = new HashSet<>();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(new EdgeComparator());

        //记录走过的点和边
        Set<Node> nodeSet = new HashSet<>();
        Set<Edge> edgeSet = new HashSet<>();

        for (Node node : graph.nodes.values()) {  //for循环是为了防止森林
            if (!nodeSet.contains(node)) {
                nodeSet.add(node);
                for (Edge edge : node.edges) {
                    if (!edgeSet.contains(edge)) {
                        edgeSet.add(edge);
                        edgeQueue.add(edge);
                    }
                }
                while (!edgeQueue.isEmpty()) {
                    Edge edge = edgeQueue.poll();
                    Node toNode = edge.to;
                    if (!nodeSet.contains(toNode)) {
                        nodeSet.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            if (!edgeSet.contains(nextEdge)) {
                                edgeSet.add(nextEdge);
                                edgeQueue.add(nextEdge);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
