package ch05_doubly_linklist;

/*
 * ˫������
 */
public class DoublyLinkedList {
	// ͷ���
	private Node first;
	// β���
	private Node last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	/**
	 * ��ͷ������Ԫ�� �Լ�д�� �о�����д����������⣬���ð�if��else����ͬ�������ȡ������ ��������һ�ֱȽϼ���д��
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
			throw new NullPointerException("����Ϊ�գ��޷�ɾ����㣡");
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
	 * ����һ����㣬��ͷ������в���
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
	 * ����һ����㣬��β�����в���
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
	 * ɾ��һ����㣬��ͷ�������ɾ��
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
	 * ɾ����㣬��β������ɾ��
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
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty() {
		return (first == null);
	}
}
