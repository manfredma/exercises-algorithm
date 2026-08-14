package manfred.exercises.leetcode.solved.p0301to0400.p0347;

import java.util.PriorityQueue;

/**
 * 前 K 个高频元素 —— 数组计数 + 小顶堆解法（重刷实现）。
 *
 * <p>思路：题目限定 nums[i] ∈ [-10^4, 10^4]，用大小 20001 的数组代替 HashMap 计数，
 * 索引 num + 10_000。再用大小为 k 的小顶堆（存计数值）筛出前 k 大的频次下限 kMin，
 * 最后一次扫描收集所有计数 ≥ kMin 的元素。
 *
 * <p>关键依赖题目保证「前 k 个高频元素的集合唯一」：即不存在并列导致筛选歧义，
 * 因此满足 count ≥ kMin 的元素恰为 k 个，不会越界。若输入违反唯一性保证
 * （并列频次），筛选会收集超过 k 个元素导致数组越界——但题目保证不会出现此输入。
 *
 * <p>复杂度：时间 O(n + N)，N=20001 为值域大小；空间 O(N)。
 * 相比 {@link Solution2} 用数组代 HashMap，省了装箱与哈希开销，但要求值域有限且已知。
 */
class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        // 数组计数：索引 num + 10_000，覆盖 [-10^4, 10^4]
        int[] numCount = new int[2 * 10_000 + 1];
        for (int num : nums) {
            int idx = num + 10_000;
            numCount[idx]++;
        }

        // 大小为 k 的小顶堆，存计数值，筛出前 k 大频次的下限 kMin
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i : numCount) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(i);
            } else {
                if (i > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(i);
                }
            }
        }

        // 题目保证答案唯一，故 count >= kMin 的元素恰为 k 个，直接收集
        int kMin = priorityQueue.peek();
        int[] result = new int[k];
        int idx = 0;
        for (int i = 0; i < numCount.length; i++) {
            if (numCount[i] >= kMin) {
                result[idx++] = i - 10_000;
            }
        }
        return result;
    }
}
