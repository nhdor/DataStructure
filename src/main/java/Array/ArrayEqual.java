package Array;

public class ArrayEqual {

    public static boolean equals(int[][] array1, int[][] array2){
        if(array1 == null || array2 == null){
            throw new NullPointerException();
        }

        if(array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if(array1[i].length != array2[i].length) return false;
            for (int j = 0; j < array1[i].length; j++) {
                    if(array1[i][j] != array2[i][j]) return false;
                }
        }
        return true;
    }

    public static <T> boolean equals(T[][] array1, T[][] array2){
        if(array1 == null || array2 == null){
            throw new NullPointerException();
        }

        if(array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if(array1[i].length != array2[i].length) return false;
            for (int j = 0; j < array1[i].length; j++) {
                if(array1[i][j] != array2[i][j]) return false;
            }
        }
        return true;
    }

}

