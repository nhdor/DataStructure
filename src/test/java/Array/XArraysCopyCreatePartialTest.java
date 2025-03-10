package Array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class XArraysCopyCreatePartialTest {
    // copy(int[] source, int startIndex, int length) 테스트

    @Test
    void testCopyIntArrayWithStartAndLength() {
        int[] source = { 1, 2, 3, 4, 5 };
        int[] destination = XArrays.copy(source, 1, 3);
        assertArrayEquals(new int[] { 2, 3, 4 }, destination);
    }

    @Test
    void testCopyIntArrayWithStartAndLength_NullSource() {
        assertThrows(NullPointerException.class, () -> XArrays.copy((int[]) null, 0, 0));
    }

    @Test
    void testCopyIntArrayWithStartAndLength_InvalidParams() {
        int[] source = { 1, 2, 3, 4, 5 };
        assertThrows(IndexOutOfBoundsException.class, () -> XArrays.copy(source, -1, 3));
        assertThrows(IllegalArgumentException.class, () -> XArrays.copy(source, 2, 10));
    }

    // copy(T[] source, int startIndex, int length) 테스트
    @Test
    void testCopyGenericArrayWithStartAndLength() {
        String[] source = { "a", "b", "c", "d", "e" };
        String[] destination = XArrays.copy(source, 1, 3);
        assertArrayEquals(new String[] { "b", "c", "d" }, destination);
    }

    @Test
    void testCopyGenericArrayWithStartAndLength_NullSource() {
        assertThrows(IllegalArgumentException.class, () -> XArrays.copy((String[]) null, 0, 0));
    }

    @Test
    void testCopyGenericArrayWithStartAndLength_InvalidParams() {
        String[] source = { "a", "b", "c", "d", "e" };
        assertThrows(IndexOutOfBoundsException.class, () -> XArrays.copy(source, -1, 3));
        assertThrows(IllegalArgumentException.class, () ->  XArrays.copy(source, 2, 10));
    }
}
