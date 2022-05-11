package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/5/10 9:05
 * @description
 */
public class BM27 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(pRoot);
        int level = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
                count--;
            }

            if (level % 2 == 0) {
                Collections.reverse(list);
            }
            level++;
            res.add(list);
        }
        return res;
    }
}
