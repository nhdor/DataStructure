package Queue;

import List.XArrayList;
import List.XList;

import java.util.Iterator;

public class XListQueue<T> implements XQueue<T>{
    XList<T> list;

    public XListQueue() {
        list = new XArrayList<>();
    }

    @Override
    public boolean enqueue(T element) {

        list.add(element);

        return true;
    }

    @Override
    public T dequeue() {
        T tmp = list.remove(0);
        return tmp;
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public XQueue<T> copy() {
        XListQueue<T> copy = new XListQueue<>();
        for (int i = 0; i < list.size(); i++) {
            copy.enqueue(list.get(i));
        }
        return copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

}
