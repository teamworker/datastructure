package ch01_array;

import java.util.HashMap;
import java.util.Map;
/**
 * 自定义数组封装类增删改查，无序数组
 * @date Apr 24, 2014--11:45:15 AM
 * @author Andy
 */
public class MyArray {

	private long[] arr;
	//表示有效数据的长度
	private int elements;
	
	public MyArray() {
		arr = new long[50];
	}
	
	public MyArray(int maxsize) {
		arr = new long[maxsize];
	}
	
	/**
	 * 添加数据
	 */
	public void insert(long value) {
		arr[elements] = value;
		elements++;
	}
	
	/**
	 * 显示数据
	 */
	public void display() {
		System.out.print("[");
		for(int i = 0; i < elements; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
	
	/**
	 * 查找数据(根据值来查找)
	 */
	public int search(long value) {
		int i;
		for(i = 0; i < elements; i++) {
			if(value == arr[i]) {
				return i;
			}
		}
			return -1;
	}
	
	/**
	 * 查找数据，根据索引来查
	 */
	public long get(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return arr[index];
		}
	}

	
	/**
	 * 删除数据
	 */
	public void delete(int index) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			for(int i = index; i < elements; i++) {
				arr[index] = arr[index + 1];
			}
			elements--;
		}
	}
	
	/**
	 * 更新数据
	 */
	public void change(int index, int newvalue) {
		if(index >= elements || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			arr[index] = newvalue;
		}
	}
}
