/**
 * 
 */
package my_thought_test;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @date Apr 26, 2014--4:38:31 PM
 * @author Andy
 */
public class OrderedArrayTest {

	/**
	 * Test method for
	 * {@link my_thought_test.OrderedArray#add(java.lang.Object)}.
	 */
	@Test
	public void testAdd(){
		OrderedArray oa = new OrderedArray();
		Person p;
		for (int i = 0; i < 19; i++) {
			p = new Person(i);
			oa.add(p);
		}
		p = new Person(7);
		oa.add(p);
		System.out.println(oa.toString());
	}

	/**
	 * Test method binarySearch
	 */
	@Test
	public void testBinarySearch(){
		OrderedArray oa = new OrderedArray();
		Person p;
		for (int i = 0; i < 19; i++) {
			p = new Person(i);
			oa.add(p);
		}
		System.out.println(oa.toString());
		Person p6 = new Person(9);
		System.out.println("ËÑË÷½á¹ûÊÇ £º "+oa.binarySearch(p6));
	}
}
