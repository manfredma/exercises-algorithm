package manfred.exercises.leetcode.solved.p3001to3100.p3096;

/**
 * LeetCode 第 3096 题「得到更多分数的最少关卡数目」：前缀和求首个 Alice 严格领先的切分点。
 *
 * <p>关卡按序游玩，Alice 完成前缀若干关（至少 1 关），Bob 完成剩余所有关；简单关
 * ({@code possible[i] == 1}) 得 {@code +1} 分，困难关 ({@code possible[i] == 0}) 得 {@code -1} 分。
 * 每关得分固定、按序进行，两人无策略选择空间，故 Alice 的得分完全由切分点决定。</p>
 *
 * <p>令 {@code total} 为全部关卡总得分，Alice 玩前 {@code i+1} 关的累计得分为 {@code alice}，
 * Bob 得分即 {@code total - alice}。Alice 严格领先需 {@code alice > total - alice}
 * （即 {@code 2 * alice > total}）。两人各至少 1 关，故 {@code i ∈ [0, n-2]}，
 * 取首个满足条件的 {@code i} 返回 {@code i + 1}；不存在则返回 {@code -1}。</p>
 *
 * <p>时间复杂度 {@code O(n)}，空间复杂度 {@code O(1)}（两趟扫描，仅累计标量，不额外建前缀和数组）。</p>
 */
class Solution {
    public int minimumLevels(int[] possible) {
        int total = 0;
        for (int p : possible) {
            total += p == 0 ? -1 : 1;
        }
        int alice = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            alice += possible[i] == 0 ? -1 : 1;
            if (alice > total - alice) {
                return i + 1;
            }
        }
        return -1;
    }
}
