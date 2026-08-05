package manfred.exercises.datastructure.tree.heap;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HeapTest {

    @Test
    public void shouldStartEmpty() {
        MaxHeap heap = new MaxHeapImpl(20);

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void shouldOfferPeekAndPollOneElement() {
        MaxHeap heap = new MaxHeapImpl(20);

        heap.offer(42);

        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
        assertEquals(42, heap.peek());
        assertEquals(1, heap.size());
        assertEquals(42, heap.poll());
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void shouldPollElementsInDescendingOrder() {
        MaxHeap heap = new MaxHeapImpl(20);
        int[] values = {3, 1, 9, 7, 2, 8, 4, 6, 5};

        for (int value : values) {
            heap.offer(value);
        }

        for (int expected = 9; expected >= 1; expected--) {
            assertEquals(expected, heap.poll());
        }
        assertTrue(heap.isEmpty());
    }

    @Test
    public void shouldSupportDuplicateValues() {
        MaxHeap heap = new MaxHeapImpl(20);
        heap.offer(4);
        heap.offer(7);
        heap.offer(7);
        heap.offer(4);
        heap.offer(7);

        assertEquals(7, heap.poll());
        assertEquals(7, heap.poll());
        assertEquals(7, heap.poll());
        assertEquals(4, heap.poll());
        assertEquals(4, heap.poll());
    }

    @Test
    public void shouldSupportNegativeAndExtremeValues() {
        MaxHeap heap = new MaxHeapImpl(20);
        heap.offer(Integer.MIN_VALUE);
        heap.offer(-1);
        heap.offer(0);
        heap.offer(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, heap.poll());
        assertEquals(0, heap.poll());
        assertEquals(-1, heap.poll());
        assertEquals(Integer.MIN_VALUE, heap.poll());
    }

    @Test
    public void shouldKeepHeapValidAfterInterleavedOperations() {
        MaxHeap heap = new MaxHeapImpl(20);
        heap.offer(5);
        heap.offer(2);
        heap.offer(8);

        assertEquals(8, heap.poll());
        heap.offer(6);
        heap.offer(10);
        assertEquals(10, heap.poll());
        assertEquals(6, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(2, heap.poll());
    }

    @Test
    public void shouldHandleManyElements() {
        MaxHeap heap = new MaxHeapImpl(1_024);
        for (int value = 1; value <= 1_024; value++) {
            heap.offer(value);
        }

        assertEquals(1_024, heap.size());
        for (int expected = 1_024; expected >= 1; expected--) {
            assertEquals(expected, heap.poll());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldRejectPeekOnEmptyHeap() {
        new MaxHeapImpl(20).peek();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldRejectPollOnEmptyHeap() {
        new MaxHeapImpl(20).poll();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectNonPositiveCapacity() {
        new MaxHeapImpl(0);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldRejectOfferWhenHeapIsFull() {
        MaxHeap heap = new MaxHeapImpl(2);
        heap.offer(2);
        heap.offer(1);

        heap.offer(3);
    }
}
