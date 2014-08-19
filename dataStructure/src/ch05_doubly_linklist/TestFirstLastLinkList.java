package ch05_doubly_linklist;

public class TestFirstLastLinkList {
	public static void main(String[] args) {
		
		FirstLastLinkList fl = new FirstLastLinkList();
//		fl.insertFirst(34);
//		fl.insertFirst(56);
//		fl.insertFirst(67);
//		fl.display();
//		
//		fl.deleteFirst();
//		fl.deleteFirst();
//		fl.display();
		
		fl.insertLast(56);
		fl.insertLast(90);
		fl.insertLast(12);

		fl.display();
		
		fl.deleteFirst();
		fl.display();
		
		/*
		 * MyTest below
		 */
		FirstLastLinkList list = new FirstLastLinkList();
		list.insertAtHead(7);
		list.insertAtEnd(12);
		list.insertAtHead(77);
		list.insertAtEnd(7);
		list.display();
	/*	
		 * 从前往后删
		 
		while(!list.isEmpty()){
			list.deleteHead();
			list.display();
		}*/
		
		/*
		 * 从后往前删
		 */
		while (!list.isEmpty()) {
			list.deleteEnd();
			list.display();
		}
		list.deleteHead();
		list.display();
	}
}
