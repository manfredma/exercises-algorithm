package manfred.exercises.leetcode.solved.p0201to0300.p0208;

/**
 * 实现 Trie（前缀树）—— 重刷实现。
 *
 * <p>Trie 是以字符为边、单词为路径的树：节点不存字符本身，字符编码在「父到子的边」上
 * （用 children[char-'a'] 的下标隐式表示）。isEnd 标记某节点是否为单词结尾，
 * 区分「完整单词」与「只是前缀」。
 *
 * <p>三个核心操作均沿字符路径行走：
 * <ul>
 *   <li>insert：逐字符建/走路径，末尾置 isEnd=true；</li>
 *   <li>search：逐字符走路径，走通且末尾 isEnd=true 才算完整单词；</li>
 *   <li>startsWith：逐字符走路径，走通即 true（不要求 isEnd）。</li>
 * </ul>
 *
 * <p>复杂度：insert/search/startsWith 均为 O(L)，L 为字符串长度，与树中词数无关。
 * 空间 O(总字符数 × 26)，小写字母场景下用固定 26 槽数组；字符集大时可换 HashMap。
 */
class Trie2 {

    private TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }

    private static class TrieNode {
        /** 标记当前节点是否为某单词结尾（区分「完整单词」与「前缀」）。 */
        private boolean isEnd;
        /** 26 个子节点，下标 idx = char - 'a' 隐式表示对应字符。 */
        TrieNode[] children = new TrieNode[26];
    }
}
