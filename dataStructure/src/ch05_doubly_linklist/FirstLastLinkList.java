package ch05_doubly_linklist;

import ch04_linklist.Node;

/*
 * ˫������
 */
public class FirstLastLinkList {
	// ͷ���
	private Node first;
	// β���
	private Node last;

	public FirstLastLinkList() {
		first = null;
		last = null;
	}

	/**
	 * �������ͷ������Ԫ�� ���Լ���д�����о��������������
	 * 
	 * @param data
	 */
	public void insertAtHead(long data) {
		Node node = new Node(data);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.next = first;
			first = node;
		}
	}

	/**
	 * �������������� ���Լ���д�����о��������������
	 * 
	 * @param data
	 */
	public void insertAtEnd(long data) {
		Node node = new Node(data);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	/**
	 * ɾ��ͷ��� �Լ�д��
	 * 
	 * @return
	 */
	public Node deleteHead() {
		Node node = first;
		if (isEmpty()) {// �������Ϊ��
			throw new NullPointerException("����Ϊ�գ�");
		} else if (first.next == null) {// ���ֻʣ��һ�����
			first = null;
			last = null;
			return node;
		} else {
			first = first.next;
			return node;
		}
	}

	/**
	 * ���������ʵ��˫�������в���Ҫ�������Ҫɾ��β������ǿ���ʹ��˫������
	 * ɾ��β��� �Լ�д��
	 * 
	 * @return
	 */
	public Node deleteEnd() {
		Node node = last;
		if (isEmpty()) {// ������
			throw new NullPointerException("����Ϊ�գ�");
		} else if (first.next == null) {// ֻʣһ��Ԫ��
			first = null;
			last = null;
			return node;
		} else {
			Node temp = first;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			last = temp;
			last.next = null;
			return node;
		}
	}

	/**
	 * ����һ����㣬��ͷ������в���
	 */
	public void insertFirst(long value) {
		Node node = new Node(value);
		if (isEmpty()) {
			last = node;
		}
		node.next = first;
		first = node;
	}

	/**
	 * ����һ����㣬��β�����в���
	 */
	public void insertLast(long value) {
		Node node = new Node(value);
		if (isEmpty()) {
			first = node;
		} else {
			last.next = node;
		}
		last = node;
	}

	/**
	 * ɾ��һ����㣬��ͷ�������ɾ��
	 */
	public Node deleteFirst() {
		Node tmp = first;
		if (first.next == null) {
			last = null;
		}
		first = tmp.next;
		return tmp;
	}

	/**
	 * ��ʾ����
	 */
	public void display() {
		Node current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * ���ҷ���
	 */
	public Node find(long value) {
		Node current = first;
		while (current.data != value) {
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	/**
	 * ɾ������������������������ɾ��
	 */
	public Node delete(long value) {
		Node current = first;
		Node previous = first;
		while (current.data != value) {
			if (current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}

		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;

	}

	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return (first == null);
	}
}
