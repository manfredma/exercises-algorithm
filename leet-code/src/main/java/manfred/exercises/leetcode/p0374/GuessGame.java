package manfred.exercises.leetcode.p0374;

/**
 * 模拟 LeetCode 第 374 题的 GuessGame 基类。
 *
 * <p>线上题目通过继承此基类获得 guess(int num) 接口；本项目无法直接继承线上基类，
 * 故在此提供等价实现：pick 作为目标数字字段，guess 依据 pick 判断大小。
 */
class GuessGame {

    protected final int pick;

    protected GuessGame(int pick) {
        this.pick = pick;
    }

    /**
     * @param num 本次猜测的数字
     * @return num > pick 返回 -1；num < pick 返回 1；相等返回 0
     */
    int guess(int num) {
        if (num > pick) {
            return -1;
        }
        if (num < pick) {
            return 1;
        }
        return 0;
    }
}
