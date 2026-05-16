package manfred.exercises.ctci.c0101;

/**
 * CTCI 面试题 01.01「判断字符是否唯一」：位向量（整型）标记字符出现，无额外数据结构。
 */
class Solution {
    public boolean isUnique(String astr) {
        int exists = 0;
        char[] chars = astr.toCharArray();
        for (char aChar : chars) {
            int shift = 1 << (aChar - 'a');
            int newExist = exists | shift;
            if (exists == newExist) {
                return false;
            }
            exists = newExist;
        }
        return true;
    }
}