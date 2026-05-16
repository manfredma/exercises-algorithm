package manfred.end.algorithm.sort.merge;

/**
 * 归并排序：基于分治思想，将数组递归二分后再有序合并，时间复杂度 O(n log n)，是稳定排序算法。
 */
public class MergeSort {
    public static void sort(int[] x) {
        System.out.println("merge sort~");
        if (x == null || x.length == 0 || x.length == 1) {
            return;
        }

        sort(x, 0, x.length - 1);
    }

    private static void sort(int[] x, int begin, int end) {
        if (begin >= end) {
            return;
        }
        // 分
        int mid = (begin + end) / 2;
        sort(x, begin, mid);
        sort(x, mid + 1, end);

        // 治（合）
        int[] tmp = new int[end - begin + 1];
        int left = begin;
        int right = mid + 1;
        for (int i = 0; i < tmp.length; i++) {
            if (right <= end && left <= mid) {
                if (x[left] < x[right]) {
                    tmp[i] = x[left];
                    left++;
                } else {
                    tmp[i] = x[right];
                    right++;
                }
            } else if (right <= end) {
                tmp[i] = x[right];
                right++;
            } else {
                tmp[i] = x[left];
                left++;
            }
        }
        for (int i = begin; i <= end; i++) {
            x[i] = tmp[i - begin];
        }
    }
}
