package com.yore.graph;

/**
 * @author Yore
 * @date 2022/1/10 10:29
 * @description
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
