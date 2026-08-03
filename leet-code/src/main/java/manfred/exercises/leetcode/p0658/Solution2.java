package manfred.exercises.leetcode.p0658;


import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 二分查找长度为 k 的窗口起点，合法起点范围是 [0, arr.length - k]。
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;

            /*
             * 比较起点为 mid 和 mid + 1 的两个相邻窗口。
             * 两者中间的 k - 1 个元素相同；右移时只会移出 arr[mid]，加入 arr[mid + k]。
             *
             * 记 F(s) 为起点为 s 的窗口内各元素到 x 的距离和：
             * F(mid + 1) - F(mid)
             *     = |arr[mid + k] - x| - |arr[mid] - x|。
             *
             * 当 arr[mid] < arr[mid + k] 时，右移后距离和变小等价于：
             * |arr[mid + k] - x| < |arr[mid] - x|
             *     <=> x > (arr[mid] + arr[mid + k]) / 2
             *     <=> x - arr[mid] > arr[mid + k] - x。
             * 即 x 位于两端元素中点的右侧，右端新加入的元素更近，应将窗口右移。
             * 若两端值相等，右移前后的窗口在此处没有差别，向右移动也不影响最终元素值。
             */
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(arr[left + i]);
        }
        return result;
    }
}
