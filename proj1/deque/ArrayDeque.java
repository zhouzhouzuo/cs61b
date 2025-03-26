package deque;

import java.util.Iterator;

public class ArrayDeque <T> implements Iterable<T>{
    private T[] items;
    private int head;
    private int tail;

    private int size;
    private int capacity;

    private int addFirstflag = 0;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        head = 8;
        tail= 0;
        capacity = 8;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int wizPos;
        public ArrayDequeIterator ( ){
            wizPos = 0;
        }
        public boolean hasNext ( ){
            if ( wizPos >= size){
                return false;
            }
            return true;
        }
        public T next ( ){
            T returnItem = get ( wizPos);
            wizPos++;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public void resizeadd(){
        int position = 0;
        int newCapacity = capacity << 1;
        T[] newitems = (T[]) new Object[newCapacity];

        for (int i = head;i < capacity;i++){
            newitems[position] = items[i];
            position += 1;
        }
        for (int i = 0;i < tail;i++){
            newitems[position] = items[i];
            position += 1;
        }

        items =newitems;

        head = 0;
        tail = capacity;
        capacity = capacity << 1;
    }

    public void resizedelete(){
        int position = 0;
        int newCapacity = capacity / 4 ;
        T[] newitems = (T[]) new Object[newCapacity];

        for (int i = 0;i < tail;i++){
            newitems[position] = items[i];
            position += 1;
        }
        position = newCapacity - 1;
        for (int i = capacity - 1 ;i >= head ;i--){
            newitems[position] = items[i];
            position -= 1;
        }

        items =newitems;

        head = newCapacity -(capacity - head);
        capacity = capacity / 4;
    }

    public void addFirst(T item){
        if (size == capacity){
            resizeadd();
        }
        addFirstflag = 1;
        head = (head - 1 + capacity) % capacity;
        items[head] = item;
        size += 1;
    }

    public void addLast(T item){
        if (size == capacity){
            resizeadd();
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i =0 ; i < size ; i++){
            int position = (head + i) % capacity;
            System.out.print(items[position]+" ");
        }
        System.out.println ( );
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }
        if (addFirstflag == 0){
            head = capacity-1;
        }
        T temp = items[head];
        head = (head + 1) % capacity;
        size -= 1;
        if ((size < capacity/ 4) && (size > 4)) {
            resizedelete();
        }
        return  temp;
    }

    public T removeLast(){
        if (size == 0){
            return null;
        }
        int position =  (tail - 1 + capacity) % capacity;
        T temp = items[position];
        tail = (tail - 1) % capacity;
        size -= 1;
        if ((size < capacity/ 4) && (size > 4)) {
            resizedelete();
        }
        return  temp;
    }

    public T get(int index){
        return  items[(head+index) % capacity];
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

//    public boolean equals(Object o){
//        if(o instanceof ArrayDeque a){
//            if (a.size != this.size){
//                return false;
//            }
//
//            for (T i : this){
//                if (!a.contains(i)){
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }

}
