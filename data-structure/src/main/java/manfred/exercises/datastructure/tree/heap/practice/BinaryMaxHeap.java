package manfred.exercises.datastructure.tree.heap.practice;

/**
 * 二叉最大堆练习骨架。
 *
 * <p>请自行决定使用 0 下标或 1 下标数组，并实现自动扩容、上滤和下滤。</p>
 */
public class BinaryMaxHeap implements MaxHeap {

    @Override
    public void offer(int value) {
        throw new UnsupportedOperationException("TODO: 实现插入与上滤");
    }

    @Override
    public int peek() {
        throw new UnsupportedOperationException("TODO: 实现查看堆顶");
    }

    @Override
    public int poll() {
        throw new UnsupportedOperationException("TODO: 实现删除堆顶与下滤");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("TODO: 实现元素计数");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("TODO: 实现空堆判断");
    }
}
