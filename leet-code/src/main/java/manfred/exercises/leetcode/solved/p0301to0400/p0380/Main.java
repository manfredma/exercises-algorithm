package manfred.exercises.leetcode.solved.p0301to0400.p0380;

import static manfred.exercises.assertion.Assert.assertEquals;
import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertInRange;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/ */

/*
实现 RandomizedSet 类：

- RandomizedSet() 初始化 RandomizedSet 对象
- bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true；否则，返回 false。
- bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true；否则，返回 false。
- int getRandom() 随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。

你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。

示例：
输入：["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
      [[], [1], [2], [2], [], [1], [2], []]
输出：[null, true, false, true, 2, true, false, 2]

提示：
- -2^31 <= val <= 2^31 - 1
- 最多调用 insert、remove 和 getRandom 函数 2 * 10^5 次
- 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
*/
/**
 * LeetCode 第 380 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        // 示例: 题面 Output
        assertTrue(randomizedSet.insert(1));    // true
        assertFalse(randomizedSet.remove(2));   // false
        assertTrue(randomizedSet.insert(2));    // true
        // getRandom 在 {1,2} 中等概率返回
        assertInRange(randomizedSet.getRandom(), 1, 2);
        assertTrue(randomizedSet.remove(1));    // true
        assertFalse(randomizedSet.insert(2));   // false
        // 此时集合仅剩 {2}，getRandom 必返回 2
        assertEquals(2, randomizedSet.getRandom());
        System.out.println("p0380 passed");
    }
}
