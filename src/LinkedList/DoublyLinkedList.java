package LinkedList;


public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	// 노드 클래스 생성
	class Node{
		private Object data;
		private Node next;
		private Node prev;

		public Node(Object input) {	// Node 클래스의 생성자 선언 -> 기본 생성자가 만들어지지 않는다.
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}

	}
	
	
	// AddFirst 첫번째에 노드 추가
	public void AddFirst(Object input) {
		Node newNode = new Node(input);
		
		newNode.next = head;
		
		
		if(head != null) {
			head.prev = newNode;
		}
		
		head = newNode;
		size ++;
		if(head.next == null) {
			tail = head;
		}
		
	}
	
	
	// AddLast 마지막에 노드 추가
	public void AddLast(Object input) {
		Node newNode = new Node(input);
		
		if(size ==0 ) {
			AddFirst(input);
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	
	// 내부적으로만 사용될 API
	Node node(int index) {
		// index가 0일때
		Node x = head;
		// index가 0 이상일때 
		for(int i =0; i< index; i++) {
			x = x.next;
		}
		return x;
	}
	
	// 특정 위치에 값 추가
	public void Add(Object input, int index) {
		Node newNode = new Node(input);
		
		if(index == 0) {
			AddFirst(input);
		} else {
			Node oldNode = node(index-1);	// 넣으려는 곳의 앞 노드를 알 수 있다.
			Node temp = oldNode.next;
			oldNode.next = newNode;
			newNode.prev = oldNode;
			newNode.next = temp;
			newNode.next.prev = newNode;
			size++;
			
			if (newNode.next == null) {
				tail = newNode;
			}
			
		}
	}
	
	
	public String toString() {
		if(head == null) {
			return "[]";
		}
		String str ="[";
		Node temp = head;
		
		while(temp.next!=null) {
			str += temp.data+",";
			temp = temp.next;
		}
		
		str += temp.data;
		
		return str+"]";
	}
	

	// 첫번째 노드 삭제
	public Object removeFirst() {
		
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		if(head != null) {
			head.prev = null;
		}
		size--;
		
		return returnData;
	}
	
	// 중간 노드 삭제
	public Object remove(int index) {
		if(index == 0) {
			return removeFirst();
		}
		Node preNode = node(index-1);
		Node todoDelete = preNode.next;
		preNode.next = preNode.next.next;
		if (preNode.next != null) {
			preNode.next.prev = preNode;
		}
		
		Object returnData = todoDelete.data;
		if(todoDelete == tail) {
			tail = preNode;
		}
		todoDelete = null;
		size--;
		
		return returnData;
	}
	
	
	
	// 마지막 노드 삭제
	public Object removeLast() {
		return remove(size-1);
	}
	
	
	// 사이즈
	public int size() {
		return size;
	}
	
	// 특정 노드 조회
	public Object get(int index) {
		Node temp = node(index);
		
		return temp;
	}
	
	
	
	
	
	
	
	

}
