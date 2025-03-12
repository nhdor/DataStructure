package List;

public class Node<T> implements Comparable<Node<T>> {

    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
        this.next = null;
    }

    @Override
    public int compareTo(Node<T> o) {
         return ((Comparable<T>) this.data).compareTo(o.data);
    }

}
