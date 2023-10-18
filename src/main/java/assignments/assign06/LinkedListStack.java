package assignments.assign06;

import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Stack<T> {

    private SinglyLinkedList<T> backingList;

    public LinkedListStack()
    {
        backingList = new SinglyLinkedList<>();
    }

    public LinkedListStack(SinglyLinkedList<T> items)
    {
        backingList = items;
    }

    @Override
    public void clear() {
        backingList.clear();
    }

    @Override
    public boolean isEmpty() {
        return backingList.isEmpty();
    }

    @Override
    public T peek() throws NoSuchElementException {
        return backingList.getFirst();
    }

    @Override
    public T pop() throws NoSuchElementException {
        return backingList.deleteFirst();
    }

    @Override
    public void push(T element) {
        backingList.insertFirst(element);
    }

    @Override
    public int size() {
        return backingList.size();
    }
}
