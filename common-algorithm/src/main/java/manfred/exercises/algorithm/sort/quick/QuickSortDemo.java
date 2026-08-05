package manfred.exercises.algorithm.sort.quick;

import java.util.Arrays;

/**
 * 快速排序演示：对多组整数数组执行快速排序并输出排序结果。
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] x = new int[]{5, 4, 3, 2, 1};
        int[] x2 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int[] x3 = {1, 2, 3, 4, 5};
        int[] x4 = {1, 32, 23, 14, 25};

        QuickSortV2.sort(x);
        QuickSortV2.sort(x2);
        QuickSortV2.sort(x3);
        QuickSortV2.sort(x4);

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(x2));
        System.out.println(Arrays.toString(x3));
        System.out.println(Arrays.toString(x4));
    }
}
