package manfred.exercises.leetcode.p0470;

/**
 * 模拟 LeetCode 第 470 题的 SolBase 基类。
 *
 * <p>线上题目通过继承此基类获得 rand7() 接口；本项目无法直接继承线上基类，
 * 故在此提供等价实现：用 java.util.Random 生成 [1,7] 均匀随机整数。
 *
 * <p>注意：Solution 中禁止直接使用 Random，必须通过 rand7() 构造 rand10()。
 */
class SolBase {

    private final java.util.Random random = new java.util.Random();

    /**
     * @return [1,7] 范围内的均匀随机整数
     */
    public int rand7() {
        return random.nextInt(7) + 1;
    }
}
