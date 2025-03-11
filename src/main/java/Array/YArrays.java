package Array;

import java.lang.reflect.Array;

public class YArrays {

    // source 배열에서 srcIndex부터 length개의 요소를 복사하여 destination 배열의 destIndex부터 저장하는 메서드를 구현
    public static void copy(int[] source, int srcIndex, int[] destination, int destIndex, int length){
        int [] tempArray = new int[source.length];

        for (int i = 0; i < source.length; i++) {
            tempArray[i] = source[i];
        }

        //source 및 destination 배열은 null이 아니어야 함.
        if(source ==null || destination == null){
            throw new NullPointerException();
        }

        //srcIndex와 destIndex는 각 배열의 유효한 범위 내에 있어야 함.
        if(srcIndex<0 ||  destIndex <0){
            throw new IndexOutOfBoundsException();
        }


        //srcIndex + length가 source.length를 초과하면 안 됨.
        if(srcIndex+length>source.length){
            throw new IllegalArgumentException("ArrayIndexOutOfBoundsException");
        }

        //destIndex + length가 destination.length를 초과하면 안 됨.
        if(destIndex+length>destination.length){
            throw new IllegalArgumentException("ArrayIndexOutOfBoundsException");
        }


        for (int i = 0; i < length; i++) {
            destination[destIndex + i] = tempArray[srcIndex + i];
        }
    }

    public static <T> void copy(T[] source, int srcIndex, T[] destination, int destIndex, int length){


        //source 및 destination 배열은 null이 아니어야 함.
        if(source ==null || destination == null){
            throw new NullPointerException();
        }

        //srcIndex와 destIndex는 각 배열의 유효한 범위 내에 있어야 함.
        if(srcIndex<0 ||  destIndex <0){
            throw new IndexOutOfBoundsException();
        }


        //srcIndex + length가 source.length를 초과하면 안 됨.
        if(srcIndex+length>source.length){
            throw new IllegalArgumentException("ArrayIndexOutOfBoundsException");
        }

        //destIndex + length가 destination.length를 초과하면 안 됨.
        if(destIndex+length>destination.length){
            throw new IllegalArgumentException("ArrayIndexOutOfBoundsException");
        }

        T [] newArray = (T[]) Array.newInstance(destination.getClass().getComponentType(), destination.length);
        for (int i = 0; i < source.length; i++) {
            newArray[i] = source[i];
        }

        if(source ==null || destination == null){
            throw new NullPointerException();
        }

        for (int i = 0; i < length; i++) {
            destination[destIndex + i] = newArray[srcIndex + i];
        }
    }


}
