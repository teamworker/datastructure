package my_thought_test;
/** 
 * 自己实现的循环队列，Queue，没有考虑多线程
 * 
 * @date Apr 29, 2014--12:14:23 PM
 * @author Andy
 */
public class MyQueue {

	private static long[] arr;
	private static int head;
	private static int tail;
	private static int size;

	public MyQueue() {
		arr = new long[12];
		head = 0;
		tail = -1;
		size = 0;
	}

	public MyQueue(int maxsize) {
		arr = new long[maxsize];
		head = 0;
		tail = -1;
		size = 0;
	}

	// TODO add
	public static long add(long element) {
		if (tail == arr.length - 1) {
			tail = -1;
		}
		arr[++tail] = element;
		size++;
		return element;
	}

	// TODO remove
	public static long remove() {
		long value = arr[head++];
		if (head == arr.length) {
			head = 0;
		}
		size--;
		return value;
	}

	// TODO peek
	public static long peek() {
		return arr[head];
	}

	// TODO isEmpty
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == arr.length;
	}

}
