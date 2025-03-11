package List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class XArrayList<T> implements XList<T>{
    //T 타입의 배열선언
    private T [] array;
    private int size = 0;
    private int capacity;

    //생성자에서초기화
    public XArrayList(){
        array = (T[]) new Object[10];
        capacity = array.length;
    }

    @Override
    public void add(T element) {
        if(element == null){
            throw new NullPointerException("element is null");
        }
        //배열 용량 초과
        if(size > capacity-1){
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[this.size++] = element;
    }

    @Override
    public void add(int index, T element) {
        if(element == null){
            throw new NullPointerException("element is null");
        }
        if(index<0){
            throw new IndexOutOfBoundsException();
        }

        //마지막 요소 저장 인덱스
        int tempIndex = this.size()-1;

        //배열 용량 초과
        if(size > capacity-1){
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }


        for (int i = tempIndex; i >= index; i--) {
            array[i+1] = array[i];
        }
        size++;
        array[index] = element;
    }

    @Override
    //T remove(int index): 특정 위치의 요소를 제거하고 반환
    public T remove(int index) {
        if(index<0 || index>=size){throw new IndexOutOfBoundsException();}
        T target = array[index];

        while(array[index]!=null){
            array[index] = array[index+1];
            index++;
        }

        array[index] = null;
        size--;

        return target;
    }

    @Override
    public boolean remove(T element) {
        if(element == null){
            throw new NullPointerException("element is null");
        }

        int targetIndex = indexOf(element);
        if(targetIndex<0) return false;
        for (int j = targetIndex; j < size-1; j++) {
            array[j] = array[j+1];
        }
        size--;
        array[size] = null;


        return true;
    }

    @Override
    public boolean contains(T element) {
        if(indexOf(element)<0) return false;
        return true;
    }

    @Override
    public int indexOf(T element) {
        int targetIdx = -1;
        for (int i = 0; i < size; i++) {
            if(element == array[i]){
                targetIdx = i;
            }
        }
        return targetIdx;
    }

    @Override
    public T get(int index) {
        if(index<0 || index>size-1) throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public void set(int index, T element) {
        array[index] = element;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort(array, 0, size, comparator);
    }

    @Override
    public XList<T> subList(int fromIndex, int toIndex) {
        XList<T> tempXList = new XArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            tempXList.add(array[i]);
        }
        return tempXList;
    }

    @Override
    public void addAll(XList<T> otherList) {
        if(size+otherList.size() > capacity){
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = 0; i < otherList.size(); i++) {
            array[size++] = otherList.get(i);
        }
    }

    @Override
    public void forEach(Consumer<T> action) {
        for (int i = 0; i < array.length; i++) {
            action.accept(array[i]);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        T[] newArray = (T[]) new Object[10];
        array = newArray;
        size=0;
    }

    @Override
    public XList<T> copy() {
        XList<T> copy = new XArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if(array[i]==null){
                break;
            }
            copy.add(array[i]);
        }

        for (int i = 0; i < array.length; i++) {

        }
        return copy;
    }

    @Override
    public String toString() {
        return "XArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
