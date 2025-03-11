package Array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayEqual2Test {

    @Test
    void testEquals_ValidArrays() {
        // 2차원 배열 비교
        Integer[][] arr1 = { {1, 2}, {3, 4, 5}, {6} };
        Integer[][] arr2 = { {1, 2}, {3, 4, 5}, {6} };
        Integer[][] arr3 = { {1, 2}, {3, 4}, {6} };

        assertTrue(ArrayEqual2.equals(arr1, arr2), "배열이 동일해야 함");
        assertFalse(ArrayEqual2.equals(arr1, arr3), "배열이 다르므로 false여야 함");
    }

    @Test
    void testEquals_NullArrays() {
        Integer[][] arr1 = null;
        Integer[][] arr2 = { {1, 2}, {3, 4} };
        Integer[][] arr3 = null;

        assertFalse(ArrayEqual2.equals(arr1, arr2), "null 배열 비교는 false여야 함");
        assertTrue(ArrayEqual2.equals(arr1, arr3), "두 개의 null 배열은 동일해야 함");
    }

    @Test
    void testEquals_EmptyArrays() {
        Integer[][] arr1 = { };
        Integer[][] arr2 = { };

        assertTrue(ArrayEqual2.equals(arr1, arr2), "빈 배열끼리는 동일해야 함");
    }

    @Test
    void testEquals_PrimitiveArrays() {
        int[][] arr1 = { {1, 2}, {3, 4, 5}, {6} };
        int[][] arr2 = { {1, 2}, {3, 4, 5}, {6} };
        int[][] arr3 = { {1, 2}, {3, 4}, {6} };

        assertTrue(ArrayEqual2.equals(arr1, arr2), "기본형 배열이 동일해야 함");
        assertFalse(ArrayEqual2.equals(arr1, arr3), "기본형 배열이 다르면 false여야 함");
    }
}
