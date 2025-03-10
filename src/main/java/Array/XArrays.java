package Array;

// 특정 위치에서부터 복사
import java.lang.reflect.Array;

public class XArrays {

    public static int[] copy(int[] source, int startIndex, int length) {
        int newArray[] = new int[length - startIndex + 1];

        if (source == null) {
            throw new NullPointerException("source is null");
        }
        if (startIndex < 0 ) {
            throw new IndexOutOfBoundsException("Invalid start index or length");
        }

        if(startIndex + length >= source.length){
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = source[i+startIndex];
        }

        return newArray;
    }

    public static <T> T[] copy(T[] source, int startIndex, int length){

        if(source == null){
            throw new IllegalArgumentException("source is null");
        }
        if (startIndex < 0 ) {
            throw new IndexOutOfBoundsException("Invalid start index or length");
        }

        if(startIndex + length > source.length){
            throw new IllegalArgumentException("IllegalArgumentException");
        }

        T[] newArray = (T[])Array.newInstance(source.getClass().getComponentType(), length);


        for (int i = 0; i < length; i++) {
            newArray[i] = source[i+startIndex];
        }
        return newArray;
    }
}


