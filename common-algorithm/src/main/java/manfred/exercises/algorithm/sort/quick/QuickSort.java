package manfred.exercises.algorithm.sort.quick;

/**
 * 快速排序：以末尾元素为基准（pivot），通过双指针分区将小于基准的元素移至左侧，递归排序两侧子数组。
 * 平均时间复杂度 O(n log n)，原地排序但不稳定。
 */
public class QuickSort {

    public static int[] sort(int[] x) {
        realSort(x, 0, x.length - 1);
        return x;
    }

    private static void realSort(int[] x, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int left = begin;
        int right = end - 1;

        int c = x[end];

        while (left < right) {
            if (x[left] < c) {
                left++;
            } else if (x[right] >= c) {
                right--;
            } else {
                int tmp = x[left];
                x[left] = x[right];
                x[right] = tmp;
                left++;
                right--;
            }
        }
        if (x[left] > c) {
            int tmp = x[left];
            x[left] = c;
            x[end] = tmp;
        }

        realSort(x, begin, left);
        realSort(x, left + 1, end);
    }
}
