package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/5 14:52
 * @description
 */
public class BM23 {
    List<Integer> list = new ArrayList<>();

    public int[] preorderTraversal(TreeNode root) {
        preOrder(root);
        return list.stream().mapToInt(Integer::new).toArray();
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
