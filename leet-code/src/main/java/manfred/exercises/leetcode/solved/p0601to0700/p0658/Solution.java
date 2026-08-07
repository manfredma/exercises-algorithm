package manfred.exercises.leetcode.solved.p0601to0700.p0658;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 先定位一个 >=x 的最小下标
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 下面用滑动窗口来进行最接近的判断
        int l = Math.max(left - k, 0), r = Math.min(left, arr.length - k);

        int diff = 0;
        for (int i = 0; i < k; i++) {
            diff += Math.abs(arr[l + i] - x);
        }
        int minDiff = diff;
        int closesIndex = l;
        for (int i = l + 1; i <= r; i++) {
            diff = diff - Math.abs(arr[i - 1] - x)  + Math.abs(arr[i + k - 1] - x);
            if (minDiff > diff) {
                closesIndex = i;
                minDiff = diff;
            }
        }

        // 构造返回结果
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(arr[i + closesIndex]);
        }
        return result;
    }
}
