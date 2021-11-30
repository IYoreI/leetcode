package com.yore.algorithm;

/**
 * @author Yore
 * @date 2021/11/29 9:30
 * @description 前缀树
 */
public class Trie {

    public class Node {
        /**
         * 拿单词构成的字典树举例来说，因为单词由字母构成，一共26个字母，每个节点需要开辟一个26个长度大小的数组，
         * 用来存储子节点的信息；另外一个字段决定当前是否遍历到字典树结束。
         * pass : 代表所有字符串中通过当前节点的数量
         * end :  代表所有字符串中以当前节点结尾的字符串的数量
         */
        public int pass;
        public int end;
        public Node[] next;

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.next = new Node[26];
        }
    }

    private Node root = new Node();

    /**
     * 插入一个单词
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] str = word.toCharArray();
        Node node = root;
        int index = 0;
        node.pass++;
        for (char c : str) {
            index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node = node.next[index];
            node.pass++;
        }
        node.end++;
    }

    /**
     * 查询指定单词出现的次数
     */
    public int search(String word) {
        if (word == null) {
            return 0;
        }
        Node node = root;
        char[] str = word.toCharArray();
        int index = 0;
        for (char c : str) {
            index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }


    public int searchPrefix(String prefix) {
        if (prefix == null) {
            return 0;
        }
        Node node = root;
        char[] str = prefix.toCharArray();
        int index = 0;
        for (char c : str) {
            index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.pass;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            Node node = root;
            node.pass--;
            char[] str = word.toCharArray();
            int index = 0;
            for (char c : str) {
                index = c - 'a';
                if (--node.next[index].pass == 0) {
                    node.next[index] = null;
                    return;
                }
                node = node.next[index];
            }
            node.end--;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("abdc");
        trie.insert("abcde");
        trie.insert("abp");
        System.out.println(trie.searchPrefix("ab"));
        System.out.println(trie.search("abdc"));
        trie.delete("abdc");
        System.out.println(trie.searchPrefix("ab"));
        System.out.println(trie.search("abdc"));
    }
}
