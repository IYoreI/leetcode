package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/5/24 9:26
 * @description
 */
public class BM40 {
    int preIndex;
    int[] preOrder;
    int[] inOrder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        this.preOrder = pre;
        this.inOrder = vin;
        preIndex = 0;
        int idx = 0;
        for (int val : vin) {
            idxMap.put(val, idx++);
        }
        return createTree(0, vin.length - 1);
    }

    public TreeNode createTree(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int val = preOrder[preIndex];
        TreeNode root = new TreeNode(val);
        preIndex++;
        int index = idxMap.get(val);
        root.left = createTree(inLeft, index - 1);
        root.right = createTree(index + 1, inRight);
        return root;
    }
}
