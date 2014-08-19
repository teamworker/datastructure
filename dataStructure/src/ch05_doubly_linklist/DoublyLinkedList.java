package ch05_doubly_linklist;

/*
 * 双向链表
 */
public class DoublyLinkedList {
	// 头结点
	private Node first;
	// 尾结点
	private Node last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	/**
	 * 在头结点插入元素 自己写的 感觉这种写法更易于理解，当让把if和else中相同的语句提取到外面 就是另外一种比较简洁的写法
	 * 
	 * @param data
	 * @return
	 */
	public Node insertAtHead(long data) {
		Node node = new Node(data);
		if (isEmpty()) {
			first = node;
			last = node;
			return node;
		} else {
			node.next = first;
			first.previous = node;
			first = node;
			return node;
		}
	}

	/**
	 * Add Element at the end of list The code style is more clear
	 * 
	 * @param data
	 * @return
	 */
	public Node insertAtEnd(long data) {
		Node node = new Node(data);
		if (isEmpty()) {
			first = node;
			last = node;
			return node;
		} else {
			last.next = node;
			node.previous = last;
			last = node;
			return node;
		}
	}

	/**
	 * Delete from head 
	 * I write it myself 
	 * The code below is more clear than the
	 * another code
	 * 
	 * @return
	 */
	public Node deleteHead() {
		Node node = first;
		if (isEmpty()) {// list is empty
			throw new NullPointerException("链表为空，无法删除结点！");
		} else if (first.next == null) {// the list has only one element
			first = null;
			last = null;
			return node;
		} else {
			first = first.next;
			first.previous = null;
			return node;
		}
	}

	/**
	 * Delete from the end of list
	 * write by myself
	 * clear code 
	 * @return
	 */
	public Node deleteEnd(){
		Node end = last;
		if(isEmpty()){
			throw new NullPointerException("you can't delete element from an empty list!");
		}else if(first.next == null){
			first = null;
			last = null;
			return end;
		}else{
			last = last.previous;
			last.next = null;
			return end;
		}
	}
	/**
	 * 插入一个结点，在头结点后进行插入
	 */
	public void insertFirst(long value) {
		Node node = new Node(value);
		if (isEmpty()) {
			last = node;
		} else {
			first.previous = node;
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
			node.previous = last;
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
		} else {
			first.next.previous = null;
		}
		first = tmp.next;
		return tmp;
	}

	/**
	 * 删除结点，从尾部进行删除
	 */
	public Node deleteLast() {
		Node tmp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return last;
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
		while (current.data != value) {
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}

		if (current == first) {
			first = first.next;
		} else {
			current.previous.next = current.next;
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
