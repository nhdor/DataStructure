package Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class XArrayQueue<T> implements XQueue<T> {

    T [] Array;
    final int INITIAL_CAPACITY = 5;
    int front;
    int rear;


    public XArrayQueue() {
        front = -1;
        rear = -1;
        Array = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public boolean enqueue(T element) {
        if(element == null) {
            throw new NullPointerException();
        }

        if(rear != -1 && rear == front || rear - front == Array.length) {
            int newCapacity = INITIAL_CAPACITY * 2;
            T[] newArray = (T[]) new Object[newCapacity];
            Array = newArray;
            return false;
        }

        int nextRearIdx = (rear + 1) % INITIAL_CAPACITY;

        Array[nextRearIdx] = element;
        rear++;

        return true;
    }

    @Override
    public T dequeue() {
        if(front == rear){
            throw new NoSuchElementException();
        }

        int nextfrontIdx = (front + 1) % INITIAL_CAPACITY;

        T temp = Array[nextfrontIdx];
        Array[nextfrontIdx] = null;

        front++;

        return temp;
    }

    @Override
    public T peek() {
        if(front == rear){
            throw new NoSuchElementException();
        }
        return Array[front+1];
    }

    @Override
    public int size() {
        if(rear>front) {
            return rear-front;
        }else if(front<rear){
            return Array.length-front+rear;
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public void clear() {
        for (int i = 0; i < Array.length; i++) {
            Array[i] = null;
        }
        front = -1;
        rear = -1;
    }

    @Override
    public XQueue<T> copy() {
        XArrayQueue copy = new XArrayQueue();
        for (int i = 0; i < Array.length; i++) {
            copy.enqueue(Array[i]);
        }
        return copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            //인덱스
            int idx;

            @Override
            public boolean hasNext() {
                if(front == rear) {
                    return false;
                }
                else{
                    return true;
                }

            }

            @Override
            public T next() {
                while(!hasNext()) {
                    idx = front + 1;
                    if(idx>Array.length-1) {
                        idx=idx % Array.length;
                    }
                }

                return Array[idx];
            }
        };
    }
}
