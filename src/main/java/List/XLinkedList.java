package List;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class XLinkedList<T> implements XList<T>{
    Node start = null;
    Node prev = null;
    int size = 0;
    T [] Nodes;

    public XLinkedList() {
    }

    @Override
    public void add(T element) {
        if(element == null){
            throw new NullPointerException("element is null");
        }
        Node newNode = new Node(element);

        if(size == 0){
            start = newNode;
        }else{
            prev = start;
            for (int i = 0; i < size-1; i++) {
                prev = prev.next;
            }
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        Node newNode = new Node(element);
        prev = start;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        Node temp = prev.next;
        prev.next = newNode;
        newNode.next = temp;

        size++;
    }

    @Override
    public T remove(int index) {
        if(size == 0){
            throw new IndexOutOfBoundsException("list is empty");
        }
        prev = start;

        if(index == 0){
            start = null;
            size--;
            return (T) prev.data;
        }

        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }

        Node<T> temp = prev.next.next;
        Node<T> del = prev.next;
        prev.next = temp;


        size--;

        return (T)del.data ;
    }

    @Override
    public boolean remove(T element) {
        prev = start;
        if(prev.data == element){
            prev.next = prev.next.next;
            size--;
            return true;
        }
        while (prev.next != null) {
            prev = prev.next;
            if(prev.data == element){
                prev.next = prev.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        prev = start;
        if(prev.data == element){
            return true;
        }
        while (prev.next != null && prev.next.data != element) {
            if(prev.next.data == element){
                return true;
            }
            prev = prev.next;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        int count = 1;

        prev = start;

        if(prev.data == element){
            return 1;
        }

        while (prev.next != null) {

            prev = prev.next;

            if(prev.data == element){
                return count;
            }

            count++;
        }

        return -1;
    }

    @Override
    public T get(int index) {
        prev = start;
        if(index<0 || index>=size){throw new IndexOutOfBoundsException();}
        if(index ==0) return (T) prev.data;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        return (T) prev.data;
    }

    @Override
    public void set(int index, T element) {
        Node newNode = new Node(element);

        prev = start;
        for (int i = 0; i < index-2; i++) {
            prev = prev.next;
        }

        Node temp = prev.next;
        prev.next = newNode;
        newNode.next = temp;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        
        Node<T>[] nodes = (Node<T>[])new Node[size];
        Node<T> prev = start;

        for (int i = 0; i < size; i++) {
            nodes[i] = prev;
            prev = prev.next;
        }

        //정렬
        Arrays.sort(nodes,0,size,Comparator.comparing(node->node.data, comparator));

        // 정렬된 순서대로 연결리스트를 재구성
        for (int i = 0; i < size - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        nodes[size - 1].next = null; // 마지막 노드의 next를 null로 설정

        start = nodes[0];
    }

    @Override
    public XList<T> subList(int fromIndex, int toIndex) {

        XLinkedList<T> sub = new XLinkedList<>();

        prev = start;
        for (int i = 0; i < fromIndex; i++) {
            prev = prev.next;
        }

        for (int i = 0; i <toIndex-fromIndex; i++) {
            sub.add((T) prev.data);
            prev = prev.next;
        }

        return sub;
    }

    @Override
    public void addAll(XList<T> otherList) {
        prev = start;
        for (int i = 0; i < size-1; i++) {
            prev = prev.next;
        }
        if(otherList instanceof XLinkedList<?>){
            prev.next= ((XLinkedList<T>) otherList).start;
        }
    }

    @Override
    public void forEach(Consumer<T> action) {
        prev = start;
        for (int i = 0; i < size-1; i++) {
            T element = (T) prev.data;
            action.accept(element);
            prev = prev.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return start == null;
    }

    @Override
    public void clear() {
        start = null;
        size = 0;
    }

    @Override
    public XList<T> copy() {
        XLinkedList<T> copy = new XLinkedList<>();

        prev = start;

        for (int i = 0; i <size; i++) {
            copy.add((T) prev.data);
            prev = prev.next;
        }

        return copy;
    }
}
