package com.yore.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Yore
 * @date 2022/1/10 10:29
 * @description
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
