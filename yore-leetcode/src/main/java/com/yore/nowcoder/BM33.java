package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/11 16:19
 * @description
 */
public class BM33 {
    public TreeNode Mirror(TreeNode pRoot) {
        return reverse(pRoot);
    }

    public TreeNode reverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = reverse(node.left);
        TreeNode right = reverse(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}
