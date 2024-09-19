package solutions.pack5_Postfix;

import java.util.ArrayList;
import java.util.Iterator;

public class MyQueueExtendsLinkedList<T> implements Iterable<T> {
    private ArrayList<T> items = new ArrayList<>();
    private int count;
    public void enqueue(T item) {
        items.add(item);
        count++;
    }
    public T peek() {
        return items.get(0);
    }
    public T dequeue() {
        T tmp = items.get(0);
        items.remove(0);
        count--;
        return tmp;
    }
    public T getLast() {
        return items.get(count - 1);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : items) {
            sb.append(t + " ");
        }
        return sb.toString();
    }
    public Iterator<T> iterator() {
        return new AnyItemsIterator(this);
    }
    private class AnyItemsIterator implements Iterator<T> {
        private MyQueueExtendsLinkedList<T> lis;
        private int idx;
        public AnyItemsIterator(MyQueueExtendsLinkedList<T> arg) {
            this.lis = arg;
        }
        @Override
        public boolean hasNext() {
            return (idx < lis.count);
        }
        @Override
        public T next() {
            return lis.items.get(idx++);
        }
    }
}
