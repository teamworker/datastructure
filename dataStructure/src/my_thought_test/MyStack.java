package my_thought_test;

/**
 * 自己实现的栈
 * 
 * @date Apr 29, 2014--11:25:50 AM
 * @author Andy
 */
public class MyStack {

	private static long[] arr;
	private static int top;

	public MyStack() {
		arr = new long[12];
		top = -1;
	}

	public MyStack(int maxsize) {
		arr = new long[maxsize];
		top = -1;
	}

	// Push
	public static long push(long value) {
		arr[++top] = value;
		return value;
	}

	// Pop
	public static long pop() {
		return arr[top--];
	}

	// peek
	public static long peek() {
		return arr[top];
	}

	// isEmpty
	public static boolean isEmpty() {
		return top == -1;
	}

	// isFull
	public static boolean isFull() {
		return top == arr.length - 1;
	}

}
