package com.yore.structure;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/28 8:24
 * @description 并查集
 */
public class UnionSet {
    Map<Integer, Node> nodes;
    Map<Node, Node> parents;
    Map<Node, Integer> sizeMap;

    public UnionSet(List<Integer> numbers) {
        this.nodes = new HashMap<>();
        this.parents = new HashMap<>();
        this.sizeMap = new HashMap<>();
        for (int num : numbers) {
            Node node = new Node(num);
            this.nodes.put(num, node);
            this.parents.put(node, node);
            this.sizeMap.put(node, 1);
        }
    }

    public boolean isSameSet(int v1, int v2) {
        if (!nodes.containsKey(v1) || !nodes.containsKey(v2)) {
            return false;
        }
        return findFather(nodes.get(v1)) == findFather(nodes.get(v2));
    }

    public Node findFather(Node node) {
        Deque<Node> queue = new LinkedList<>();
        while (node != parents.get(node)) {
            node = parents.get(node);
            queue.offerLast(node);
        }
        while (!queue.isEmpty()) {
            parents.put(queue.pollLast(), node);
        }
        return node;
    }


    public void union(int v1, int v2) {
        Node p1 = findFather(nodes.get(v1));
        Node p2 = findFather(nodes.get(v2));
        if (p1 != p2) {
            int aSize = sizeMap.get(p1);
            int bSize = sizeMap.get(p2);
            Node bigNode = aSize > bSize ? p1 : p2;
            Node smallNode = bigNode == p1 ? p2 : p1;
            parents.put(smallNode, bigNode);
            sizeMap.put(bigNode, aSize + bSize);
            sizeMap.remove(smallNode);
        }
    }
}

class Node {
    Integer value;

    public Node(int value) {
        this.value = value;
    }
}



