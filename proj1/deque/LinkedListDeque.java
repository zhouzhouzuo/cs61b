package deque;

import java.util.Deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>{
    public class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(T i, IntNode n,IntNode N) {
            item = i;
            next = n;
            prev = N;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new IntNode(null,null,null);
        size = 0;
    }

    private class LinkedListDequeIterator implements Iterator<T>{
        int wizPos;
        public LinkedListDequeIterator ( ){
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
        return new LinkedListDequeIterator ( );
    }

    public void addFirst(T item){
        IntNode temp = new IntNode(item,null,null);
        if (size == 0){
            sentinel.next = temp;
            temp.prev = sentinel;
            sentinel.prev = temp;
            temp.next = sentinel;
        }
        else {
            sentinel.next.prev = temp;
            temp.next = sentinel.next;
            sentinel.next = temp;
            temp.next = sentinel;
        }
        size += 1;
    }

    public void addLast(T item){
        IntNode temp = new IntNode(item,null,null);
        if (size == 0){
            sentinel.next = temp;
            temp.prev = sentinel;
            sentinel.prev = temp;
            temp.next = sentinel;
        }
        else {
            sentinel.prev.next = temp;
            temp.prev = sentinel.prev;
            temp.next = sentinel;
            sentinel.prev = temp;
        }
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode temp = sentinel.next;
        for ( int i = 0; i<size; ++i){
            System.out.print ( temp.item+" ");
            temp = temp.next;
        }
        System.out.println ( );
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }
        IntNode temp = sentinel.next;
        if (size == 1){
            sentinel.next = null;
            sentinel.prev = null;
        }
        else {
            temp.next.prev = sentinel;
            sentinel.next = temp.next;
        }
        size -= 1;

        return  temp.item;
    }

    public T removeLast(){
        if (size == 0){
            return null;
        }
        IntNode temp = sentinel.prev;
        if (size == 1){
            sentinel.next = null;
            sentinel.prev = null;
        }
        else {
            temp.prev.next = sentinel;
            sentinel.prev = temp.prev;
        }
        size -= 1;

        return temp.item;
    }

    public T get(int index){
        if (index > size){
            return null;
        }

        IntNode temp = sentinel.next;
        for ( int i = 0; i<index; ++i){
            temp = temp.next;
        }
        return  temp.item;
    }

    public T gethelp(int index , int cur, IntNode curnode){
        if (index == cur){
            return curnode.item;
        }
        return gethelp(index,cur+1,curnode.next);
    }

    public T getRecursive(int index){
        if (index > size){
            return null;
        }
        return  gethelp(index,0,sentinel.next);
    }

    public boolean contains(T x) {
        IntNode temp = sentinel.next;
        while (temp != sentinel){
            if (temp.item == x){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

//    public boolean equals(Object o){
//        if(o instanceof LinkedListDeque a){
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
