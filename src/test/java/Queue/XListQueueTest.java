package Queue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * XListQueue 클래스의 테스트를 수행합니다.
 */
public class XListQueueTest {

    private XQueue<Integer> queue;

    /**
     * 각 테스트 메서드 실행 전 큐를 초기화합니다.
     */
    @BeforeEach
    void setUp() {
        queue = new XListQueue<>(); // 구현체를 여기에 사용
    }

    /**
     * enqueue() 메서드를 사용하여 요소를 추가하고 큐의 크기를 확인합니다.
     */
    @Test
    void testEnqueueAndSize() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(2, queue.size());
    }

    /**
     * dequeue() 메서드를 사용하여 큐에서 요소를 제거하고 확인합니다.
     */
    @Test
    void testDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.dequeue()); // 첫 번째로 추가된 요소가 반환되어야 함
        assertEquals(1, queue.size());

        assertEquals(20, queue.dequeue()); // 다음 요소가 반환됨
        assertEquals(0, queue.size());
    }

    /**
     * dequeue()를 빈 큐에서 호출할 경우 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testDequeueOnEmptyQueue() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    /**
     * peek() 메서드를 사용하여 큐의 첫 번째 요소를 확인합니다.
     */
    @Test
    void testPeek() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.peek()); // 첫 번째 요소 확인
        assertEquals(2, queue.size()); // 요소는 제거되지 않음
    }

    /**
     * peek()을 빈 큐에서 호출할 경우 예외가 발생하는지 테스트합니다.
     */
    @Test
    void testPeekOnEmptyQueue() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.peek());
    }

    /**
     * isEmpty() 메서드를 사용하여 큐가 비어 있는지 확인합니다.
     */
    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(10);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    /**
     * clear() 메서드를 사용하여 큐를 비우고 확인합니다.
     */
    @Test
    void testClear() {
        queue.enqueue(10);
        queue.enqueue(20);

        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    /**
     * 큐의 복사본을 만들어 원본 큐와 독립적으로 작동하는지 확인합니다.
     */
    @Test
    void testCopy() {
        queue.enqueue(10);
        queue.enqueue(20);

        XQueue<Integer> copyQueue = queue.copy();
        assertEquals(2, copyQueue.size());
        assertEquals(10, copyQueue.peek());

        copyQueue.dequeue();
        assertEquals(1, copyQueue.size());
        assertEquals(20, copyQueue.peek());
        assertEquals(2, queue.size()); // 원본 큐는 변경되지 않음
    }

    /**
     * Null 값 입력을 처리하는지 테스트합니다.
     */
    @Test
    void testNullValidation() {
        assertThrows(NullPointerException.class, () -> queue.enqueue(null));
    }
}
