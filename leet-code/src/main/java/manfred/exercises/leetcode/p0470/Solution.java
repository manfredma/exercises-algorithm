package manfred.exercises.leetcode.p0470;

/**
 * LeetCode 第 470 题「用 Rand7() 实现 Rand10()」。
 *
 * <p>核心思想：拒绝采样（Rejection Sampling）。
 * <ol>
 *   <li>两次 rand7() 拼出均匀的 [1,49]：
 *       {@code idx = (rand7()-1)*7 + rand7()}，可看成 7×7 方阵的编号。</li>
 *   <li>保留 [1,40]（40 是 ≤49 的最大 10 的倍数），
 *       {@code (idx-1) % 10 + 1} 均匀映射到 [1,10]。</li>
 *   <li>idx ∈ [41,49] 的 9 个值整组丢弃，重来。</li>
 * </ol>
 * 关键：要等概率生成 10 个值，采样范围必须是 10 的整数倍；
 *       多出来的非整数倍部分必须丢弃，不可用 %10 截断非整数倍范围。
 *
 * <p>rand7() 调用次数期望：单轮命中概率 40/49，期望轮数 49/40 ≈ 1.225，
 *       每轮 2 次调用，故期望 ≈ 2.45 次。
 */
class Solution extends SolBase {

    public int rand10() {
        int idx;
        do {
            // 两次 rand7 拼成 [1,49] 的均匀分布
            idx = (rand7() - 1) * 7 + rand7();
        } while (idx > 40);   // 丢弃 41..49，重来
        return (idx - 1) % 10 + 1;
    }
}
