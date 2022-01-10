package com.yore.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/10 10:29
 * @description 图中点的信息
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
