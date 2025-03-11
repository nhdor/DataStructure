package Array;

import java.lang.reflect.Array;

public class twoDArray {

    public static int[][] deepCopy(int[][] source){
        if(source==null){
            throw new NullPointerException("source is null");
        }
        for (int i = 0; i < source.length; i++) {
            if(source[i]==null){
                throw new NullPointerException("source[" +i+ "] is null");
            }
        }

        int [][] newArray = new int[source.length][];

        for (int i = 0; i < source.length; i++) {
            newArray[i] = new int[source[i].length];
            for (int j = 0; j < source[i].length; j++) {
                newArray[i][j] = source[i][j];
            }
        }
        return newArray;
    }

    public static <T> T[][] deepCopy(T[][] source){

        if(source==null){
            throw new NullPointerException("source is null");
        }
        for (int i = 0; i < source.length; i++) {
            if(source[i]==null){
                throw new NullPointerException("source[" +i+ "] is null");
            }
        }

        T [][] newArray = (T[][]) Array.newInstance(source.getClass().getComponentType(), source.length);

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = (T[]) Array.newInstance(source[i].getClass().getComponentType(), source[i].length);
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = source[i][j];
            }
        }

        return newArray;
    }
    public static Object[] deepCopy(Object[] source){

        if(source==null){
            throw new NullPointerException("source is null");
        }
        for (int i = 0; i < source.length; i++) {
            if(source[i]==null){
                throw new NullPointerException("source[" +i+ "] is null");
            }
        }

        // 원본 배열과 동일한 런타임 타입의 배열 생성
        Object[] ObjArray = (Object[]) java.lang.reflect.Array.newInstance(source.getClass().getComponentType(), source.length);


        for (int i = 0; i < source.length; i++) {
            if (source[i] instanceof Object[]) {
                ObjArray[i] = deepCopy((Object[]) source[i]);
            } else if (source[i] != null && source[i].getClass().isArray()) {
                // 기본형 배열인 경우 처리 (예: int[], double[] 등)
                if (source[i].getClass().getComponentType().isPrimitive()) {
                    int len = java.lang.reflect.Array.getLength(source[i]);
                    Object copy = java.lang.reflect.Array.newInstance(source[i].getClass().getComponentType(), len);
                    System.arraycopy(source[i], 0, copy, 0, len);
                    ObjArray[i] = copy;
                } else {
                    // 만약 참조형 배열인데 instanceof Object[] 조건에 걸리지 않은 경우 (드물지만)
                    ObjArray[i] = deepCopy((Object[]) source[i]);
                }
            } else {
                ObjArray[i] = source[i];
            }
        }
        return ObjArray;
    }

}
