package Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * XArrayQueue 클래스의 테스트를 수행합니다.
 */
public class XArrayQueueTest {
    private XQueue<Integer> queue;

    /**
     * 각 테스트 메서드 실행 전 큐를 초기화합니다.
     */
    @BeforeEach
    void setUp() {
        queue = new XArrayQueue<>(); // 구현체를 여기에 사용
    }

    /**
     * 요소 추가 및 크기 확인 테스트를 수행합니다.
     */
    @Test
    void testEnqueueAndSize() {
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());
    }

    /**
     * dequeue()를 사용하여 요소 제거 및 반환 테스트를 수행합니다.
     */
    @Test
    void testDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.dequeue()); // 가장 먼저 삽입된 요소 반환 (FIFO)
        assertEquals(1, queue.size());

        assertEquals(20, queue.dequeue()); // 다음 요소 반환
        assertEquals(0, queue.size());
    }

    /**
     * dequeue()를 빈 큐에서 호출할 경우 예외 발생 테스트를 수행합니다.
     */
    @Test
    void testDequeueOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    /**
     * peek()을 사용하여 큐의 첫 번째 요소 확인 테스트를 수행합니다.
     */
    @Test
    void testPeek() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.peek()); // 가장 앞의 요소 확인 (10)
        assertEquals(2, queue.size()); // 요소는 제거되지 않음
    }

    /**
     * peek()을 빈 큐에서 호출할 경우 예외 발생 테스트를 수행합니다.
     */
    @Test
    void testPeekOnEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    /**
     * isEmpty()가 올바르게 동작하는지 확인 테스트를 수행합니다.
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
     * clear()를 사용하여 모든 요소 제거 테스트를 수행합니다.
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
     * Null 값 입력 검증 테스트를 수행합니다.
     */
    @Test
    void testNullValidation() {
        assertThrows(NullPointerException.class, () -> queue.enqueue(null));
    }

    /**
     * 큐가 가득 찼을 때 enqueue() 동작 검증 테스트를 수행합니다.
     */
    @Test
    void testEnqueueWhenFull() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // 큐가 꽉 차서 더 이상 추가되지 않아야 함
        assertFalse(queue.enqueue(60));
    }

    /**
     * 큐의 순차적 순회(Iterator) 동작을 테스트합니다.
     */
}
