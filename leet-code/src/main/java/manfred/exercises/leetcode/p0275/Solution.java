package manfred.exercises.leetcode.p0275;

class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int len = citations.length - mid;
            if (citations[mid] >= len) {
                // 分数较高时，继续在左侧查找, 但是不能跳过当前可能是正确答案的元素
                right = mid;
            } else {
                // 分数不够高了
                left = mid + 1;
            }
        }
        return citations.length - right;
    }
}
