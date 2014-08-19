package my_thought_test;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	MyLinkedList list = new MyLinkedList();

	@Test
	public void testAddFirst() {
		for (int i = 6; i < 12; i++) {
			list.addFirst(i);
		}
	}

	@Test
	public void testFind() {
		testAddFirst();
		list.display();
		System.out.println("\n" + list.find(9));
	}

	@Test
	public void testDelete() {
		testAddFirst();
		System.out.println("The deleted Node is " + list.delete(7));
		list.display();
	}

}
