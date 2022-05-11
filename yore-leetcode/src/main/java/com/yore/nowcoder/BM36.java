package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/11 16:33
 * @description
 */
public class BM36 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!IsBalanced_Solution(root.left) || !IsBalanced_Solution(root.right)) {
            return false;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(left - right) <= 1;
    }


    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return 1 + Math.max(left, right);
    }
}
