package messCode.meeting12;

import assignments.assign04.OutOfRangeException;

/**
 * Class representing a linked list where the data is an integer.
 * 
 * @author Aaron Wood
 * @version 2023-10-03
 */
public class IntegerLinkedList {
	
	/**
	 * Node for the linked list with an integer value
	 * and a reference to the next node.
	 */
	private class Node {
		public int value;
		public Node next;
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node head;
	private int length;
	
	/**
	 * Create an empty integer linked list.
	 */
	public IntegerLinkedList() {
		this.head = null;
		this.length = 0;
	}
	
	/**
	 * Compute the number of integers in the linked list.
	 * @return
	 */
	public int size() {
		return this.length;
	}
	
	/**
	 * Add an integer to the front of the linked list.
	 * @param value
	 */
	public void addFirst(int value) {
		this.head = new Node(value, this.head);
		this.length++;
	}
	
	/**
	 * Remove the first integer from the linked list.
	 */
	public void removeFirst() {
		if(head == null) throw new IllegalStateException("Linked list is empty");
		this.head = this.head.next;
	}
	
	/**
	 * Insert an integer to the linked list at the given index.
	 * @param index
	 * @param value
	 */
	public void insert(int index, int value) {
		if(index > this.length) throw new OutOfRangeException("Index " + index + " is out of bounds for length " + this.length);
		if(index == 0)
		{
			this.addFirst(value);
			return;
		}
		Node hand = this.head;
		for(int i = 0; i < index - 1; i++)
		{
			hand = hand.next;
		}
		hand.next = new Node(value, hand.next);
		this.length++;
	}
	
	/**
	 * Generate a string representation of the linked list.
	 * 
	 * e.g. 1 -> 5 -> 3 -> 2
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node hand = this.head;
		while(hand.next != null)
		{
			sb.append(hand.value).append(", ");
			hand = hand.next;
		}
		sb.append(hand.value).append("]");
		return sb.toString();
	}
	
}
