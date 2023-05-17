package offer;

/**
 * @Author zhulang
 * @Date 2023-05-16
 **/
public class Offer62_2 {

    public static class TrieNode {
        public int pass;
        public int end;
        // HashMap<Char, Node> nexts;
        // TreeMap<Char, Node> nexts;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            // nexts[0] == null 没有走向‘a’的路
            // nexts[0] != null 有走向‘a’的路
            // ...
            // nexts[25] != null 有走向‘z’的路
            nexts = new TrieNode[26];
        }
    }
    public static class Trie {

        private TrieNode root;


        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) { // 从左往右遍历字符
                index = chs[i] - 'a'; // 由字符，对应成走向哪条路
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return false;
                }
                node = node.nexts[index];
            }
            return node.end > 0;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null) {
                return false;
            }
            char[] chs = prefix.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return false;
                }
                node = node.nexts[index];
            }
            return node.pass > 0;
        }
    }
}
