package Array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayEqualTest {

    @Test
    void testIntArrayEquals() {
        int[][] array1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] array2 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] array3 = {
                {1, 2},
                {4, 5, 6}
        };

        int[][] array4 = {
                {1, 2, 3},
                {4, 5, 7}
        };

        assertTrue(ArrayEqual.equals(array1, array2));  // 같은 배열 -> true
        assertFalse(ArrayEqual.equals(array1, array3)); // 크기가 다른 배열 -> false
        assertFalse(ArrayEqual.equals(array1, array4)); // 값이 다른 배열 -> false
    }

    @Test
    void testGenericArrayEquals() {
        String[][] array1 = {
                {"A", "B", "C"},
                {"D", "E", "F"}
        };

        String[][] array2 = {
                {"A", "B", "C"},
                {"D", "E", "F"}
        };

        String[][] array3 = {
                {"A", "B"},
                {"D", "E", "F"}
        };

        String[][] array4 = {
                {"A", "B", "C"},
                {"D", "E", "G"}
        };

        assertTrue(ArrayEqual.equals(array1, array2));  // 같은 배열 -> true
        assertFalse(ArrayEqual.equals(array1, array3)); // 크기가 다른 배열 -> false
        assertFalse(ArrayEqual.equals(array1, array4)); // 값이 다른 배열 -> false
    }
}
