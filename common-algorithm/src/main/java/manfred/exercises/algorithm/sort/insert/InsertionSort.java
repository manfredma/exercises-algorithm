package manfred.exercises.algorithm.sort.insert;

/**
 * 插入排序：将未排序元素逐一插入到已排序序列的正确位置，时间复杂度 O(n²)，适合小规模或近乎有序的数组。
 */
public class InsertionSort {
    public static void sort(int[] x) {
        System.out.println("insert sort: ");
        if (x == null || x.length == 0 || x.length == 1) {
            return;
        }

        for (int i = 1; i < x.length; i++) {
            // 查找过程可以使用二分查找优化，但是节点需要依次后移无法优化！
            for (int j = 0; j < i; j++) {
                if (x[i] < x[j]) {
                    int tmp = x[i];
                    x[i] = x[j];
                    x[j] = tmp;
                }
            }
        }
    }
}
