package Stack;
import List.Node;
import List.XLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class XLinkedStack<T> implements XStack<T>{
    Node<T> head;

    public XLinkedStack() {
    }

    @Override
    public void push(T element) {
        if(element == null){
            throw new NullPointerException();
        }
        if(head == null) {
            head = new Node<>(element);
        }else{
            Node<T> newNode = new Node<>(element);
            newNode.next = head;
            head = newNode;
        }

    }

    @Override
    public T pop() {
        if(head == null){
            throw new NoSuchElementException();
        }
        T temp = head.data;
        head = head.next;

        return temp;
    }

    @Override
    public T peek() {
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {

        if(head == null){
            return 0;
        }else{
            Iterator<T> iterator = iterator();
            int cnt = 1;
            while(iterator.hasNext() ){
                cnt++;
            }
            return cnt;
        }


    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if(head.next != null){
                    head = head.next;
                    return true;
                }else{
                    return false;
                }
            }

            @Override
            public T next() {
                if(head != null){
                    head = head.next;
                }
                return head.data;
            }
        };
    }
}
