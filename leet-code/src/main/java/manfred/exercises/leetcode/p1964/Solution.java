package manfred.exercises.leetcode.p1964;

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int[] result = new int[obstacles.length];

        // 对高度序列做 LIS，patience sorting，O(n log n)
        int[] tails = new int[obstacles.length];
        int len = 0;

        for (int i = 0; i < obstacles.length; i++) {
            int h = obstacles[i];
            int idx = upperBound(tails, 0, len, h);
            tails[idx] = h;
            if (idx == len) {
                len++;
            }
            result[i] = idx + 1;
        }
        return result;
    }

    private int upperBound(int[] tails, int from, int to, int key) {
        while (from < to) {
            int mid = (from + to) >>> 1;
            if (tails[mid] <= key) {
                from = mid + 1;
            } else {
                to = mid;
            }
        }
        return from;
    }
}
