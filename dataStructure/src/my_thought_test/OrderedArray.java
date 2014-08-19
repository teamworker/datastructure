package my_thought_test;

import java.util.Collections;
import java.util.HashMap;

/**
 * 在这个类中练习或验证一些编程想法
 * 
 * @date Apr 24, 2014--4:11:00 PM
 * @author Andy
 * @param <T>
 */

/*
 * 自己实现一个有序数组
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
	 * 增加，保持有序
	 */
	public void add(Object o) {
		/*
		 * 如果数组满了，则分配更多空间
		 */
		if (isFull()) {
			size <<= 1;
			Object[] newArr = new Object[size];
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr;
		}
		/*
		 * 向有序数组中添加一个元素
		 */
		/**
		 * 一定要注意数组的边界元素！
		 */
		if (index == 0) {
			arr[0] = o;
		}

		for (int i = index; i > 0; i--) {
			if (((Person) arr[i - 1]).compareTo((Person) o) == 1) {
				arr[i] = arr[i - 1];
				System.out.println("向后移动！");
			} else {
				arr[i] = o;
				System.out.println("加入元素！");
				break;
			}
		}
		index++;
	}

	/**
	 * 查找： 因为是有序数组，所以可以使用二分查找，对于无序数组，只能使用线性查找
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
					low = middle + 1;//这里是middle+1，调整low值，只关心大的一半
				} else {
					high = middle - 1;//这里是middle-1，调整high值，只关心小的一半
				}
			}
		}
	}

	/**
	 * 删除： 删除时任然保持数组有序，应该提供两种删除方法，一种通过索引，一种通过对象（删除第一个相同的对象或基本类型） ①通过索引删除
	 */
	public void delete(int index) {
		if (index < 0 | index > this.index) {
			throw new ArrayIndexOutOfBoundsException("索引值不合法！");
		}
		for (int i = index; i < this.index; i++) {
			arr[i] = arr[i + 1];
		}
	}

	/**
	 * ②通过值删除
	 */
	public void delete(Object o) {

	}

	/*
	 * 判断数组是否满了
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
 * 用于测试有序数组的
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
