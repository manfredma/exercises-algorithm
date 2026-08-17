package manfred.exercises.leetcode.solved.p0201to0300.p0208;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/implement-trie-prefix-tree/ */

/*
请你实现 Trie 类：
- Trie()
- void insert(String word)
- boolean search(String word)
- boolean startsWith(String prefix)

示例操作序列：
["Trie","insert","search","search","startsWith","insert","search"]
[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
输出：[null,null,true,false,true,null,true]
*/
/**
 * LeetCode 第 208 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例：官方用例
        Trie trie = new Trie();
        trie.insert("apple");
        assertEquals(true, trie.search("apple"));      // 完整单词存在
        assertEquals(false, trie.search("app"));        // 仅前缀，非完整单词
        assertEquals(true, trie.startsWith("app"));     // 前缀存在
        trie.insert("app");
        assertEquals(true, trie.search("app"));         // 现在是完整单词

        // 重刷：Trie2 走相同操作序列
        Trie2 trie2 = new Trie2();
        trie2.insert("apple");
        assertEquals(true, trie2.search("apple"));
        assertEquals(false, trie2.search("app"));
        assertEquals(true, trie2.startsWith("app"));
        trie2.insert("app");
        assertEquals(true, trie2.search("app"));

        // 边界: 空串前缀（任何已插入串都有空前缀）
        assertEquals(true, trie.startsWith(""));
        assertEquals(true, trie2.startsWith(""));

        // 边界: 不存在的前缀
        assertEquals(false, trie.startsWith("banana"));
        assertEquals(false, trie.search("banana"));
        assertEquals(false, trie2.startsWith("banana"));
        assertEquals(false, trie2.search("banana"));

        // 边界: 前缀是已插入串的超集
        assertEquals(false, trie.search("apples"));
        assertEquals(false, trie2.search("apples"));
    }

}
