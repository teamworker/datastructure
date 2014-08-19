package my_thought_test;

import java.util.Collections;
import java.util.HashMap;

/**
 * �����������ϰ����֤һЩ����뷨
 * 
 * @date Apr 24, 2014--4:11:00 PM
 * @author Andy
 * @param <T>
 */

/*
 * �Լ�ʵ��һ����������
 */
public class OrderedArray {

	private Object[] arr;
	private int size;
	private int index = 0;

	public OrderedArray() {
		size = 1 << 4;
		arr = new Object[size];
	}

	public OrderedArray(int size) {
		this.size = size;
		arr = new Object[size];
	}

	/*
	 * ���ӣ���������
	 */
	public void add(Object o) {
		/*
		 * ����������ˣ���������ռ�
		 */
		if (isFull()) {
			size <<= 1;
			Object[] newArr = new Object[size];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr;
		}
		/*
		 * ���������������һ��Ԫ��
		 */
		/**
		 * һ��Ҫע������ı߽�Ԫ�أ�
		 */
		if (index == 0) {
			arr[0] = o;
		}

		for (int i = index; i > 0; i--) {
			if (((Person) arr[i - 1]).compareTo((Person) o) == 1) {
				arr[i] = arr[i - 1];
				System.out.println("����ƶ���");
			} else {
				arr[i] = o;
				System.out.println("����Ԫ�أ�");
				break;
			}
		}
		index++;
	}

	/**
	 * ���ң� ��Ϊ���������飬���Կ���ʹ�ö��ֲ��ң������������飬ֻ��ʹ�����Բ���
	 */
	public int binarySearch(Object o) {
		int middle =0, low = 0, high = index - 1;
		while (true) {
			middle = (low + high) / 2;

			if (((Person) arr[middle]).compareTo((Person) o) == 0) {
				return middle;
			} else if (low > high) {
				return -1;
			} else {
				if (((Person) arr[middle]).compareTo((Person) o) == -1) {
					low = middle + 1;//������middle+1������lowֵ��ֻ���Ĵ��һ��
				} else {
					high = middle - 1;//������middle-1������highֵ��ֻ����С��һ��
				}
			}
		}
	}

	/**
	 * ɾ���� ɾ��ʱ��Ȼ������������Ӧ���ṩ����ɾ��������һ��ͨ��������һ��ͨ������ɾ����һ����ͬ�Ķ����������ͣ� ��ͨ������ɾ��
	 */
	public void delete(int index) {
		if (index < 0 | index > this.index) {
			throw new ArrayIndexOutOfBoundsException("����ֵ���Ϸ���");
		}
		for (int i = index; i < this.index; i++) {
			arr[i] = arr[i + 1];
		}
	}

	/**
	 * ��ͨ��ֵɾ��
	 */
	public void delete(Object o) {

	}

	/*
	 * �ж������Ƿ�����
	 */
	private boolean isFull() {
		return arr.length == index + 1 ? true : false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < this.index; i++) {
			sb.append(" Person ").append(i).append(" : ");
			sb.append(" age : ").append(((Person) arr[i]).getAge())
					.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
}

/*
 * ���ڲ������������
 */
class Person implements Comparable<Person> {

	private String name;
	private int age;
	private int height;
	private int weight;

	public Person() {
	}

	public Person(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (this.age > o.age) {
			return 1;
		} else if (this.age < o.age) {
			return -1;
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
