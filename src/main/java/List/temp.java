package List;


public class temp {
    public static void main(String[] args) {


        XList<Integer> list = new XLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.remove(1));

        System.out.println(list.get(1));

    }
}
