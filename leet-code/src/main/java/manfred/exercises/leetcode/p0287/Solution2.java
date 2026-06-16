package manfred.exercises.leetcode.p0287;

/**
 * LeetCode 第 287 题「寻找重复数」：Floyd 判圈算法（快慢指针），视数组为链表寻找环入口。
 */
class Solution2 {
    public int findDuplicate(int[] nums) {
        // Phase 1：快慢指针找到环内相遇点
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2：重置一个指针到起点，两者同速前进，相遇处即环入口（重复数字）
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
