package stack;

public class Stack_1 implements Stack{
	
	private int stackSize;
	private int stackArr[];
	private int top;
	
	// 생성자 생성
	public Stack_1(int stackSize) {
		this.stackArr = new int[stackSize];
		this.stackSize = stackSize;
		this.top = -1;	// null과 같은것
	}

	@Override
	public boolean isFull() {
		return (top == this.stackSize-1);
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public void push(int input) {
		if(isFull()) {
			System.out.println("isFull");
		} else {
			stackArr[++top] = input;
			System.out.println("Inserted Item : " + input);
		}
	}

	
	@Override
	public int pop() {
		if(isEmpty()) {
			System.out.println("isEmpty");
			return 0;
		} else {
			System.out.println("Deleted Item : "+stackArr[top]);
			return stackArr[top--];
		}
	}

	@Override
	public int peek() {
		if(isEmpty()) {
			System.out.println("isEmpty");
			return 0;
		} else {
			System.out.println(stackArr[top]);
			return stackArr[top];
		}
	}
	

	@Override
	public void clear() {
		if(isEmpty()) {
			System.out.println("Stack is already empty!");
		} else {
			top =-1;
			stackArr = new int[this.stackSize];	// 새로운 스택 배열 생성
			System.out.println("Stack is clear!");
		}
	}
	
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Empty");
		} else {
			for(int i =0; i < top; i++) {
                System.out.print(stackArr[i] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int stackSize = 5;
		
		Stack_1 st = new Stack_1(stackSize);
		
		st.push(1);
		st.push(2);
		st.push(3);
		
		st.pop();
		st.pop();
		
		st.peek();
		
		st.push(5);
		
		st.printStack();
		
		st.clear();
		
		st.printStack();
	}

}
