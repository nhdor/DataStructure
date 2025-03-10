import java.util.Arrays;

public class referenceTypeCopy {

    static public void main(String[] args) {
        Box [] box = new Box[10];

        for (int i = 1; i < 10; i++) {
            box[i] = new Box(i);
        }

        Box [] copyBox = Arrays.copyOfRange(box, 3,5);
        for (int i = 0; i < copyBox.length; i++) {
            copyBox[i].up();
        }

        for (int i = 0; i <10; i++) {
            System.out.println(box[i]);
        }

        for (int i = 0; i < copyBox.length; i++) {
            System.out.println(copyBox[i]);
        }


    }
}


class Box {
    int number;

    Box(int n){
        number = n;
    }

    void up(){
        number++;
    }

    @Override
    public String toString() {
        return "Box{" +
                "number=" + number +
                '}';
    }
}