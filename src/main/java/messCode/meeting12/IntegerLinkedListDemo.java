package messCode.meeting12;

/**
 * Demo class to see the result of our integer linked list.
 * 
 * @author Aaron Wood
 * @version 2023-10-03
 */
public class IntegerLinkedListDemo {
	
	public static void main(String[] args) {
		IntegerLinkedList list = new IntegerLinkedList();
		
		list.addFirst(5);
		list.addFirst(2);
		list.addFirst(1);
		list.addFirst(8);
		list.addFirst(3);
		
		System.out.println(list);
	}

}
