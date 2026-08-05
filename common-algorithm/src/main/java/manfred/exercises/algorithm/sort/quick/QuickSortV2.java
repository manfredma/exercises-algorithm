package manfred.exercises.algorithm.sort.quick;

/**
 * 快速排序：以末尾元素为基准（pivot），通过双指针分区将小于基准的元素移至左侧，递归排序两侧子数组。
 * 平均时间复杂度 O(n log n)，原地排序但不稳定。
 */
public class QuickSortV2 {

    public static int[] sort(int[] x) {
        quick(x, 0, x.length - 1);
        return x;
    }

    private static void quick(int[] x, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = x[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (x[j] < pivot) {
                i++;
                swap(x, i, j);
            }
        }
        // 把均分元素
        swap(x, i + 1, end);
        quick(x, begin, i);
        quick(x, i + 2, end);
    }

    private static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }
}
