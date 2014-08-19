package ch05_doubly_linklist;

public class TestDoubleLinkList {
	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insertLast(45);
		dl.insertLast(56);
		dl.insertLast(90);
		dl.display();
		
		
		while(!dl.isEmpty()) {
			dl.deleteFirst();
			dl.display();
		}
		
		System.out.println("Test My Code.............");
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtHead(7);
		list.insertAtHead(12);
		list.display();
		list.insertAtEnd(77);
		list.insertAtEnd(666);
		list.display();
		
		/*System.out.println("My deletFirst code test.......");
		while(!list.isEmpty()){
			list.deleteHead();
			list.display();
		}*/
		System.out.println("My deletEnd code test.......");
		while(!list.isEmpty()){
			list.deleteEnd();
			list.display();
		}
//		list.deleteHead();
		list.deleteEnd();
		list.display();
		
		
	}
}
