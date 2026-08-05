package manfred.exercises.datastructure.tree.heap;

import java.util.NoSuchElementException;

/**
 * 基于整数的最大堆。
 *
 * <p>堆顶始终是当前所有元素中的最大值。相同元素允许重复插入。</p>
 */
public interface MaxHeap {

    /**
     * 插入一个元素。
     *
     * @param value 待插入的值
     */
    void offer(int value);

    /**
     * 查看堆顶最大值，但不移除它。
     *
     * @return 当前最大值
     * @throws NoSuchElementException 堆为空时抛出
     */
    int peek();

    /**
     * 移除并返回堆顶最大值。
     *
     * @return 当前最大值
     * @throws NoSuchElementException 堆为空时抛出
     */
    int poll();

    /**
     * @return 堆中元素个数
     */
    int size();

    /**
     * @return 堆中没有元素时返回 {@code true}
     */
    boolean isEmpty();
}
