package assignments.assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T> {

    private int size = 0;
    private Node head = null;

    public SinglyLinkedList()
    {}

    @Override
    public void insertFirst(T element)
    {
        this.head = new Node(element, this.head);
        size++;
    }

    @Override
    public void insert(int index, T element) throws IndexOutOfBoundsException
    {
        if(index > this.size || index < 0) throw new IndexOutOfBoundsException();
        if(index == 0)
        {
            insertFirst(element);
            return;
        }
        Node curr = this.head;
        while(index > 1)
        {
            curr = curr.next;
            index--;
        }

        curr.next = new Node(element, curr.next);
    }

    @Override
    public T getFirst() throws NoSuchElementException
    {
        if(this.head == null) throw new NoSuchElementException();
        return this.head.data;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException
    {
        if(index >= this.size || index < 0) throw new IndexOutOfBoundsException();
        Node curr = this.head;
        while(index > 0)
        {
            curr = curr.next;
            index--;
        }
        return curr.data;
    }

    @Override
    public T deleteFirst() throws NoSuchElementException
    {
        if(this.head == null) throw new NoSuchElementException();
        T item = this.head.data;
        this.head = this.head.next;
        this.size--;
        return item;
    }

    @Override
    public T delete(int index) throws IndexOutOfBoundsException
    {
        if(index >= this.size || index < 0) throw new IndexOutOfBoundsException();
        if(index == 0)
        {
            return deleteFirst();
        }
        Node curr = this.head;
        while(index > 1)
        {
            curr = curr.next;
            index--;
        }
        T item = curr.next.data;
        curr.next = curr.next.next;
        this.size--;
        return item;
    }

    @Override
    public int indexOf(T element)
    {
        int index = 0;
        Node curr = this.head;
        while(curr != null)
        {
            if(curr.data.equals(element)) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return this.size == 0;
    }

    @Override
    public void clear()
    {
        this.head = null;
        this.size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray()
    {
        T[] output = (T[]) new Object[this.size];
        Node curr = this.head;
        int index = 0;
        while(curr != null)
        {
            output[index] = curr.data;
            index++;
            curr = curr.next;
        }
        return output;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new SinglyIterator();
    }

    protected class SinglyIterator implements Iterator<T> {

        private Node curr = head;
        private Node last = null;

        @Override
        public boolean hasNext()
        {
            return curr != null;
        }

        @Override
        public T next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            T item = curr.data;
            if(!(curr == head || curr == head.next)) if(last == null) last = head;
            else last = last.next;
            curr = curr.next;
            return item;
        }

        @Override
        public void remove()
        {
            if(!hasNext()) throw new NoSuchElementException();
            if(last == null) deleteFirst();
            else {
                last.next = curr;
            }
        }
    }

    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
