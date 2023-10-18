package messCode.meeting13;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    private int size = 0;
    private Node head;

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
        this.head = null;
    }

    @Override
    public E peek() throws NoSuchElementException {
        if(this.head == null) throw new NoSuchElementException("Linked stack is empty");
        return this.head.item;
    }

    @Override
    public E pop() throws NoSuchElementException {
        if(this.head == null) throw new NoSuchElementException("Linked stack is empty");

        E item = this.head.item;
        this.head = this.head.next;
        size--;
        return item;
    }

    @Override
    public void push(E element) {
        this.head = new Node(element, this.head);
        size++;
    }

    protected class Node {
        public E item;
        public Node next;

        public Node(E item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }
}
