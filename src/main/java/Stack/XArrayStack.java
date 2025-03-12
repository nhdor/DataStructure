package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class XArrayStack<T> implements XStack<T>{
    private T [] Array = (T[]) new Object[10];
    private int size = 0;

    @Override
    public void push(T element) {
        if(element == null){
            throw new NullPointerException();
        }
        if(size+1>Array.length){
            T [] newArray = (T[]) new Object[size*2];
            for (int i = 0; i < Array.length; i++) {
                newArray[i] = Array[i];
            }
            Array = newArray;
        }
        Array[size++] = element;
    }

    @Override
    public T pop() {

        if(size==0){
            throw new NoSuchElementException();
        }

        T tmp = Array[size-1];
        Array[size--] = null;
        return tmp;
    }

    @Override
    public T peek() {
        if(size==0){
            throw new NoSuchElementException();
        }
        return Array[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        T [] newArray = (T[]) new Object[size*2];
        Array = newArray;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < Array.length;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new IllegalStateException();
                }
                return Array[index++];
            }
        };
    }

}
