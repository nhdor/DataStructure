package Queue;

import List.XArrayList;
import java.util.Comparator;
import java.util.Iterator;

//우선순위 큐
public class XPriorityQueue<T> implements XQueue<T> {

    XArrayList<T> list;
    Comparator<T> comparator;

    public XPriorityQueue(Comparator<T> comparator)
    {
        list = new XArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public boolean enqueue(T element) {
        return false;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public XQueue<T> copy() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
