package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/5/23 14:10
 * @description 判断是否是完全二叉树
 */
public class BM35 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        boolean complete = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            if (cur == null) {
                complete = true;
                continue;
            }
            if (complete) {
                return false;
            }
            queue.offerLast(cur.left);
            queue.offerLast(cur.right);
        }
        return true;
    }
}
