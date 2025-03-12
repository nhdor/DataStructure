package List;

public class Node<T> implements Comparable<Node<T>> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }

    @Override
    public int compareTo(Node<T> o) {
         return ((Comparable<T>) this.data).compareTo(o.data);
    }

}
