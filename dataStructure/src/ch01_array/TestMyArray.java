package ch01_array;

public class TestMyArray {
	public static void main(String[] args) {
		MyArray arr = new MyArray();
		arr.insert(13);
		arr.insert(34);
		arr.insert(90);
		
		arr.display();
		System.out.println(arr.search(190));
		
		System.out.println(arr.get(1));
		
		arr.change(0, 12);
		arr.display();
		MyOrderArray ordArr = new MyOrderArray();
		ordArr.insert(90);
		ordArr.insert(30);
		ordArr.insert(80);
		ordArr.insert(10);
		ordArr.display();
		
		System.out.println(ordArr.binarySearch(20));
	}
}
