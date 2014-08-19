package ch05_doubly_linklist;

import ch04_linklist.Node;

/*
 * 双端链表
 */
public class FirstLastLinkList {
	// 头结点
	private Node first;
	// 尾结点
	private Node last;

	public FirstLastLinkList() {
		first = null;
		last = null;
	}

	/**
	 * 在链表的头部插入元素 我自己的写法，感觉这样更容易理解
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
	 * 在链表最后插入结点 我自己的写法，感觉这样更易于理解
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
	 * 删除头结点 自己写的
	 * 
	 * @return
	 */
	public Node deleteHead() {
		Node node = first;
		if (isEmpty()) {// 如果链表为空
			throw new NullPointerException("链表为空！");
		} else if (first.next == null) {// 如果只剩下一个结点
			first = null;
			last = null;
			return node;
		} else {
			first = first.next;
			return node;
		}
	}

	/**
	 * 这个方法其实在双端链表中不需要，如果需要删除尾结点我们可以使用双向链表
	 * 删除尾结点 自己写的
	 * 
	 * @return
	 */
	public Node deleteEnd() {
		Node node = last;
		if (isEmpty()) {// 空链表
			throw new NullPointerException("链表为空！");
		} else if (first.next == null) {// 只剩一个元素
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
	 * 插入一个结点，在头结点后进行插入
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
	 * 插入一个结点，从尾结点进行插入
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
	 * 删除一个结点，在头结点后进行删除
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
	 * 显示方法
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
	 * 查找方法
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
	 * 删除方法，根据数据域来进行删除
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
	 * 判断是否为空
	 */
	public boolean isEmpty() {
		return (first == null);
	}
}
