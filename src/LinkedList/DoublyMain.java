package LinkedList;

public class DoublyMain {
	public static void main(String[] args) {
		DoublyLinkedList numbers = new DoublyLinkedList();
		
		numbers.AddFirst(20);
		numbers.AddFirst(10);
		
		
		numbers.AddLast(50);
		numbers.AddLast(60);
		
		numbers.Add(40, 2);
		
		System.out.println(numbers);
		
		numbers.removeFirst();

		System.out.println(numbers);
		
		numbers.remove(0);
		numbers.remove(2);

		System.out.println(numbers);
		
	}
}

