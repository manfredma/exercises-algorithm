package manfred.exercises.datastructure.tree.heap;

/**
 * 基于大顶堆的堆排序：将元素依次入堆后逐一取出堆顶最大值，实现升序排列，时间复杂度 O(n log n)。
 */
public class HeapSort {

    public int[] sort(int[] source) {

        MaxHeap heap = new MaxHeapImpl(source.length);
        for (int i : source) {
            heap.offer(i);
        }

        int[] result = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            result[source.length - 1 - i] = heap.poll();
        }
        return result;
    }
}
