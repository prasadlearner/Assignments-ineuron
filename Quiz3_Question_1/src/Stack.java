
/*
 * 
 * Implement a stack using an array in Java. Include the necessary methods such as push, pop, and isEmpty.
 */

class Stack {
	int maxSize;
	int top;
	int[] array;

	public Stack(int capacity) {
		maxSize = capacity;
		top = -1;
		array = new int[maxSize];
	}

	public void push(int value) {
		if (top == maxSize - 1) {
			System.out.println("Stack overflow");
			return;
		}
		array[++top] = value;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		return array[top--];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}