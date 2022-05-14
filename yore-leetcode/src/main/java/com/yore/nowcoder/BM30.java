package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/14 10:15
 * @description
 */
public class BM30 {
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode p = pRootOfTree;
        while (p.left != null) {
            p = p.left;
        }
        inOrder(pRootOfTree);
        return p;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        inOrder(node.right);
    }
}
