package manfred.exercises.datastructure.tree.heap;

import java.util.NoSuchElementException;

/**
 * 固定容量的二叉最大堆。
 *
 * <p>使用 0 下标数组存储元素；堆满时插入会抛出异常。</p>
 */
public class MaxHeapImpl implements MaxHeap {

    private final int[] heap;

    private int size;

    public MaxHeapImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        heap = new int[capacity];
    }

    @Override
    public void offer(int value) {
        if (size == heap.length) {
            throw new IllegalStateException("heap is full");
        }
        heap[size] = value;
        siftUp(size);
        size++;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    @Override
    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int result = heap[0];
        heap[0] = heap[--size];
        siftDown(0);

        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index] <= heap[parentIndex]) {
                return;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        while (true) {
            int leftChildIndex = index * 2 + 1;
            if (leftChildIndex >= size) {
                return;
            }

            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex < size && heap[rightChildIndex] > heap[leftChildIndex]) {
                largerChildIndex = rightChildIndex;
            }
            if (heap[index] >= heap[largerChildIndex]) {
                return;
            }
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }
}
