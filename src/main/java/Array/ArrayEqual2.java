package Array;


import java.lang.reflect.Array;

public class ArrayEqual2 {
    public static boolean equals(Object array1, Object array2){

        if(array1 == null || array2 == null){
            throw new NullPointerException();
        }

        if (array1 instanceof int[][]) {
            int[][] arr1 = (int[][]) array1;
            int[][] arr2 = (int[][]) array2;

            if (arr1.length != arr2.length) return false;

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i].length != arr2[i].length) return false;
                for (int j = 0; j < arr1[i].length; j++) {
                    if (arr1[i][j] != arr2[i][j]) return false; // 기본형 배열의 값 비교
                }
            }

        } else if (array1 instanceof Object[][]) {
            Object[][] arr1 = (Object[][]) array1;
            Object[][] arr2 = (Object[][]) array2;

            if (arr1.length != arr2.length) return false;

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i].length != arr2[i].length) return false;
                for (int j = 0; j < arr1[i].length; j++) {
                    if (!arr1[i][j].equals(arr2[i][j])) return false; // 참조형 배열의 값 비교
                }
            }
        }
        return true;
    }

}
