package ds;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private class Node {
        T item;
        Node next;

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node front;
    private Node back;
    private int length = 0;

    public void enqueue(T item) {
        Node node = new Node(item, null);
        if (isEmpty()) {
            front = node;
            back = front;
        } else {
            back.next = node;
            back = node;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = front.item;
        front = front.next;
        if (front == null) {
            back = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {}
    }
}
