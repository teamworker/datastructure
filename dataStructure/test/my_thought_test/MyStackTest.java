package my_thought_test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {

	MyStack stack = new MyStack(17);

	@Test
	public void testPush() {
		for (int i = 0; i < 12; i++) {
			stack.push(i);
		}
	}

	@Test
	public void testPop() {
		testPush();
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+"   ");
		}
	}

	@Test
	public void testPeek() {
		testPush();
		System.out.println(stack.peek());
	}

}
