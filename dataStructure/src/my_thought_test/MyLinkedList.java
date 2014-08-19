package my_thought_test;

/**
 * 自己实现的链表
 * 
 * @date Apr 29, 2014--9:51:09 PM
 * @author Andy
 */
public class MyLinkedList {

	private Node first;
	private Node current;
	private Node previous;

	/*
	 * 增加
	 */
	public Node addFirst(long value) {
		Node node = new Node(value);
		// 常见错误 node.next = first.next;
		node.next = first;// 这种是在链表最前面加结点
		first = node;
		return node;
	}

	/*
	 * 查找
	 */
	public Node find(long value) {
		current = first;
		while (current.data != value) {
			if (current == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	/*
	 * 删除
	 */
	public Node delete(long value) {

		current = first;
		while (current.data != value) {
			if (current == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		/*
		 * 要特别处理头结点
		 */
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;

	}

	public void display() {
		current = first;
		while (current != null) {
			System.out.print(current.toString() + "  ");
			current = current.next;
		}
	}

	private class Node {
		private long data;
		private Node next;

		public Node(long data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node : " + data;
		}
	}
}
