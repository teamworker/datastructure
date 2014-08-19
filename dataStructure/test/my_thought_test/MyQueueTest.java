package my_thought_test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyQueueTest {

	MyQueue queue = new MyQueue(12);

	@Test
	public void testAdd() {
		for (int i = 3; i < 9; i++) {
			queue.add(i);
		}
	}

	@Test
	public void testRemove() {
		testAdd();
		while (!queue.isEmpty()) {
			System.out.print(queue.remove() + "   ");
		}
	}

	@Test
	public void testPeek() {
		testAdd();
		System.out.println(queue.peek());
	}

}
