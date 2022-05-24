package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.*;

/**
 * @author Yore
 * @date 2022/5/24 8:57
 * @description 重建二叉树 输出右视图
 */
public class BM41 {
    int preIndex;
    int[] preOrder;
    int[] inOrder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public int[] solve(int[] xianxu, int[] zhongxu) {
        this.preIndex = 0;
        this.preOrder = xianxu;
        this.inOrder = zhongxu;
        int index = 0;
        for (int val : zhongxu) {
            idxMap.put(val, index++);
        }
        TreeNode root = createTree(0, zhongxu.length - 1);
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            TreeNode pre = null;
            while (count > 0) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                pre = node;
                count--;
            }
            if (pre != null) {
                list.add(pre.val);
            }
        }
        return list.stream().mapToInt(Integer::new).toArray();
    }

    public TreeNode createTree(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int val = preOrder[preIndex++];
        TreeNode node = new TreeNode(val);
        int index = idxMap.get(val);
        node.left = createTree(inLeft, index - 1);
        node.right = createTree(index + 1, inRight);
        return node;
    }
}
