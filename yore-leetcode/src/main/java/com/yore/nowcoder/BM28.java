package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/10 8:52
 * @description 二叉树最大深度
 */
public class BM28 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
