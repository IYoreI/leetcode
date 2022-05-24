package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.*;

/**
 * @author Yore
 * @date 2022/5/24 8:22
 * @description 层序遍历求解二叉树两个节点的最近公共祖先
 */
public class BM38 {
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        Map<Integer, Integer> parents = new HashMap<>();
        Deque<TreeNode> queue = new LinkedList<>();
        parents.put(root.val, -1);
        queue.offerLast(root);
        while (!parents.containsKey(o1) || !parents.containsKey(o2)) {
            TreeNode node = queue.pollFirst();
            if (node.left != null) {
                parents.put(node.left.val, node.val);
                queue.offerLast(node.left);
            }
            if (node.right != null) {
                parents.put(node.right.val, node.val);
                queue.offerLast(node.right);
            }
        }
        Set<Integer> accessor = new HashSet<>();
        while (parents.containsKey(o1)) {
            accessor.add(o1);
            o1 = parents.get(o1);
        }
        while (!accessor.contains(o2)) {
            o2 = parents.get(o2);
        }
        return o2;
    }
}
