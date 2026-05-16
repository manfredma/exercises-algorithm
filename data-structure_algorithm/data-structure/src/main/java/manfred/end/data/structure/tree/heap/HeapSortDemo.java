package manfred.end.data.structure.tree.heap;

/**
 * 堆排序演示：使用堆结构对整数数组进行排序并输出结果。
 */
public class HeapSortDemo {

    public static void main(String[] args) {
        int[] src = new int[]{0, 1, 101, 1, 105, 10, 11, 6, 13, 15, 18, 9, 8, 4,};
        int[] dst = new HeapSort().sort(src);

        for (int i : dst) {
            System.out.print(i + "->");
        }
    }
}
