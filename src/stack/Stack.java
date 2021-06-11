package stack;

public interface Stack {
	boolean isFull();
	boolean isEmpty();
	void push(int input);
	int pop();
	int peek();
	void clear();
	
}
