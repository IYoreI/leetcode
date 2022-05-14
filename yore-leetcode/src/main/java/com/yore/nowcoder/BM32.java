package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/12 10:25
 * @description
 */
public class BM32 {
    public TreeNode mergeTrees(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        if (n1 == null || n2 == null) {
            return n1 == null ? n2 : n1;
        }
        n1.val = n1.val + n2.val;
        n1.left = mergeTrees(n1.left, n2.left);
        n1.right = mergeTrees(n1.right, n2.right);
        return n1;
    }
}
