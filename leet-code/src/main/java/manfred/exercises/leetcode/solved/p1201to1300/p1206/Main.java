package manfred.exercises.leetcode.solved.p1201to1300.p1206;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/design-skiplist/ */

/**
 * LeetCode 第 1206 题（设计跳表）的测试入口，对比 Skiplist 与 SkiplistV2 两种实现。
 */
public class Main {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.add(4);
        // System.out.println("init: \n" + skiplist);

        assertFalse(skiplist.search(0));   // return false.
        assertTrue(skiplist.search(1));    // return true.
        assertFalse(skiplist.erase(0));   // return false, 0 is not in skiplist.
        // System.out.println("after erase 0: \n" + skiplist);
        assertTrue(skiplist.erase(1));     // return true.
        // System.out.println("after erase 1: \n" + skiplist);
        assertFalse(skiplist.search(1));   // return false, 1 has already been erased.
        // System.out.println("after erase 1: \n" + skiplist);
        assertTrue(skiplist.erase(3));    // return true
        System.out.println("after erase 3: \n" + skiplist);

        System.out.println("=============================================================");
        SkiplistV2 skiplistV2 = new SkiplistV2();
        skiplistV2.add(1);
        skiplistV2.add(2);
        skiplistV2.add(3);
        skiplistV2.add(4);
        // System.out.println("init: \n" + skiplist);

        assertFalse(skiplistV2.search(0));   // return false.
        assertTrue(skiplistV2.search(1));     // return true.
        assertFalse(skiplistV2.erase(0));    // return false, 0 is not in skiplist.
        // System.out.println("after erase 0: \n" + skiplist);
        assertTrue(skiplistV2.erase(1));     // return true.
        // System.out.println("after erase 1: \n" + skiplist);
        assertFalse(skiplistV2.search(1));   // return false, 1 has already been erased.
        // System.out.println("after erase 1: \n" + skiplist);
        assertTrue(skiplistV2.erase(3));    // return true
        System.out.println("after erase 3: \n" + skiplistV2);
        System.out.println("passed");
    }
}
