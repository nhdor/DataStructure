package List;

public class Node<T> implements Comparable<Node<T>> {
    static int index = 0;

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        index++;
    }

    public Node() {
    }

    @Override
    public int compareTo(Node<T> o) {
         return ((Comparable<T>) this.data).compareTo(o.data);
    }
}
