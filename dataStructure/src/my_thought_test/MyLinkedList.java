package my_thought_test;

/**
 * �Լ�ʵ�ֵ�����
 * 
 * @date Apr 29, 2014--9:51:09 PM
 * @author Andy
 */
public class MyLinkedList {

	private Node first;
	private Node current;
	private Node previous;

	/*
	 * ����
	 */
	public Node addFirst(long value) {
		Node node = new Node(value);
		// �������� node.next = first.next;
		node.next = first;// ��������������ǰ��ӽ��
		first = node;
		return node;
	}

	/*
	 * ����
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
	 * ɾ��
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
		 * Ҫ�ر���ͷ���
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
