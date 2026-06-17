package manfred.exercises.leetcode.p0380;

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
        System.out.println(randomizedSet.insert(1));    // 期望 true
        System.out.println(randomizedSet.remove(2));    // 期望 false
        System.out.println(randomizedSet.insert(2));    // 期望 true
        System.out.println(randomizedSet.getRandom());  // 期望 1 或 2
        System.out.println(randomizedSet.remove(1));    // 期望 true
        System.out.println(randomizedSet.insert(2));    // 期望 false
        System.out.println(randomizedSet.getRandom());  // 期望 2
    }
}
