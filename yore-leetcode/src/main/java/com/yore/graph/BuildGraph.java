package com.yore.graph;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/13 11:39
 * @description
 */
public class BuildGraph {

    public static void main(String[] args) {
        BuildGraph bg = new BuildGraph();
        System.out.println(bg.buildOption1(new int[][]{{0, 2, 2}, {0, 5, 6}, {1, 0, 3}, {1, 4, 5}, {2, 1, 1}, {2, 3, 3}, {2, 3, 4}, {3, 4, 2}, {4, 5, 1}}));
    }

    //通过权重构建图
    public Graph buildOption1(int[][] edges) {
        Graph g = new Graph();
        for (int[] info : edges) {
            Node from;
            if (g.nodes.containsKey(info[0])) {
                from = g.nodes.get(info[0]);
            } else {
                from = new Node(info[0]);
                g.nodes.put(info[0], from);
            }
            Node to;
            if (g.nodes.containsKey(info[1])) {
                to = g.nodes.get(info[1]);
            } else {
                to = new Node(info[1]);
                g.nodes.put(info[1], to);
            }
            Edge edge = new Edge(info[2], from, to);
            from.out += 1;
            to.in += 1;
            from.edges.add(edge);
            from.nexts.add(to);
            g.edges.add(edge);
        }
        return g;
    }


    class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    class Node {
        public int val;
        public int in;
        public int out;
        public List<Node> nexts;
        public List<Edge> edges;

        public Node(int val) {
            this.val = val;
            this.in = 0;
            this.out = 0;
            this.nexts = new ArrayList<>();
            this.edges = new ArrayList<>();
        }
    }

    class Graph {
        public Map<Integer, Node> nodes;
        public Set<Edge> edges;

        public Graph() {
            this.nodes = new HashMap<>();
            this.edges = new HashSet<>();
        }
    }


}
