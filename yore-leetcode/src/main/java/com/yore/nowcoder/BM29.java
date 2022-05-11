package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/10 9:31
 * @description
 */
public class BM29 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }

    public boolean helper(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            return true;
        }
        return helper(node.left, sum) || helper(node.right, sum);
    }
}
