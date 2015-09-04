package ds;

public class LinkedList {
    private Node head;
    private int length;

    public void insertFront(String data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        length++;
    }

    public void insertBack(String data) {
        if (head == null) {
            insertFront(data);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node node = new Node(data);
            current.setNext(node);
            length++;
        }
    }

    public void insertPosition(String data, int position) {
        if (position < 0 || position > length) {
            throw new ArrayIndexOutOfBoundsException(position);
        }

        if (position == 0) {
            insertFront(data);
        } else if (position == length) {
            insertBack(data);
        } else {
            Node next = head;
            Node previous = head;

            for (int i = 0; i < position; i++) {
                previous = next;
                next = previous.getNext();
            }
            Node node = new Node(data);
            node.setNext(next);
            previous.setNext(node);
        }
    }

    public String removeFront() {
        if (head == null) {
            return null;
        }
        Node node = head;
        head = head.getNext();

        return node.getData();
    }

    public String removeBack() {
        if (head == null) {
            return null;
        } else if (head.getNext() == null) {
            String result = head.getData();
            head = null;
            length--;
            return result;
        } else {
            Node nodeToRemove = head;
            Node previous = head;

            for (int i = 0; i < length; i++) {
                previous = nodeToRemove;
                nodeToRemove = previous.getNext();
            }

            previous.setNext(null);
            length--;
            return nodeToRemove.getData();
        }
    }

    public String removePosition(int position) {
        if (position < 0 || position > length) {
            throw new ArrayIndexOutOfBoundsException(position);
        }

        if (position == 0) {
            return removeFront();
        } else if (position == length - 1) {
            return removeBack();
        } else {
            // this is EXACTLY the same as the last part of removeBack - I'd refactor into its own method.
            Node nodeToRemove = head;
            Node previous = head;

            for (int i = 0; i < position; i++) {
                previous = nodeToRemove;
                nodeToRemove = previous.getNext();
            }

            previous.setNext(null);
            length--;
            return nodeToRemove.getData();
        }
    }


    public static void main(String[] args) {
        Node first = new Node("A");
        Node second = new Node("B");
        Node third = new Node("C");

        first.setNext(second);
        second.setNext(third);
    }
}
