package com.yore.nowcoder;

import com.yore.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yore
 * @date 2022/5/24 9:11
 * @description
 */
public class BM39 {
    String Serialize(TreeNode root) {
        return preSerialize(root, "");
    }

    private String preSerialize(TreeNode node, String str) {
        if (node == null) {
            str += "null,";
            return str;
        }
        str += String.valueOf(node.val + ",");
        str = preSerialize(node.left, str);
        str = preSerialize(node.right, str);
        return str;
    }

    TreeNode Deserialize(String str) {
        String[] strArr = str.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strArr));
        return preDeserialize(list);
    }

    private TreeNode preDeserialize(List<String> dataList) {
        if (dataList.size() == 0) {
            return null;
        }
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = preDeserialize(dataList);
        root.right = preDeserialize(dataList);
        return root;
    }
}
