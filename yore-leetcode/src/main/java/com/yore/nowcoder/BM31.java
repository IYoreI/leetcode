package com.yore.nowcoder;

import com.yore.base.TreeNode;

/**
 * @author Yore
 * @date 2022/5/11 16:09
 * @description
 */
public class BM31 {
    boolean isSymmetrical(TreeNode pRoot) {
        return isSym(pRoot, pRoot);
    }

    public boolean isSym(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null || p1.val != p2.val) {
            return false;
        }
        return isSym(p1.left, p2.right) && isSym(p1.right, p2.left);
    }
}
