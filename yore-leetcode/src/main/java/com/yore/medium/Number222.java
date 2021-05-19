package com.yore.medium;

import com.yore.base.TreeNode;

/**
 * @author jia bing wen
 * @date 2021/5/19 9:46
 * @description
 */
public class Number222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
