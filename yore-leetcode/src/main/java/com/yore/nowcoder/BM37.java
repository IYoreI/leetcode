package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/12 10:37
 * @description
 */
public class BM37 {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root.val >= p && root.val <= q || root.val <= p && root.val >= q) {
            return root.val;
        }
        if (root.val >= p) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
