package manfred.exercises.leetcode.solved.p0201to0300.p0208;

/**
 * 实现 Trie（前缀树）—— 初版实现。
 *
 * <p>节点用 children[26] 数组表示子节点（下标 idx = char - 'a'），isEnd 标记单词结尾。
 * insert/search/startsWith 沿字符路径行走，O(L) 时间。与 {@link Trie2} 同结构，
 * 此版方法注释为英文，{@code TrieNode} 为私有静态内部类。
 */
class Trie {

    TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null) {
                current.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            current = current.children[word.charAt(i) - 'a'];
        }
        current.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] != null) {
                current = current.children[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return current.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.children[prefix.charAt(i) - 'a'] != null) {
                current = current.children[prefix.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }

    private static class TrieNode {
        /**
         * 本节点是否是某个单次的结束
         */
        private boolean isEnd;

        /**
         * 子节点
         */
        private TrieNode[] children = new TrieNode[26];
    }

}
