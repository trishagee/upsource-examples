package ds;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node top; // top of the stack

    private class Node {
        T item;
        Node next;

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node node = top;
        top = top.next;
        return node.item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
        }
    }
}