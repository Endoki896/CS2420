package messCode.meeting13;

public class Demo {
	public static void main(String[] args) {
		QueueDemo();
	}
	
	public static void stackDemo() {
		String word;
		Stack<String> words = new ArrayStack<String>();
		
		words.push("one");
		words.push("two");
		words.push("three");
		words.push("four");
		
		System.out.println(words.size());  // should be 4
		
		word = words.peek();
		System.out.println(word);  // should be four
		
		word = words.pop();
		System.out.println(word);  // should be four
		
		word = words.pop();
		System.out.println(word);  // should be three
		
		word = words.peek();
		System.out.println(word);  // should be two
		System.out.println(words.size());  // should be 2
		
		words.push("five");
		
		word = words.peek();
		System.out.println(word);  // should be five
		System.out.println(words.size());  // should be 3
	}
	
	public static void QueueDemo() {
		String word;
		Queue<String> words = new ArrayQueue<String>();

		words.enqueue("one");
		words.enqueue("two");
		words.enqueue("three");
		words.enqueue("four");
		
		System.out.println(words.size());  // should be 4
		
		word = words.peek();
		System.out.println(word);  // should be one
		
		word = words.dequeue();
		System.out.println(word);  // should be one
		
		word = words.dequeue();
		System.out.println(word);  // should be two
		
		word = words.peek();
		System.out.println(word);  // should be three
		System.out.println(words.size());  // should be 2
		
		words.enqueue("five");
		
		word = words.peek();
		System.out.println(word);  // should be three
		System.out.println(words.size());  // should be 3
	}
}
