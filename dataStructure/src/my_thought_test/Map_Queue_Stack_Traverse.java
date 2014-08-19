package my_thought_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 遍历Map，Queue 和 Stack的方法，不同于普通的Collection
 * 
 * @date Apr 29, 2014--12:44:31 PM
 * @author Andy
 */
public class Map_Queue_Stack_Traverse {

	public static void main(String[] args) {

		/**
		 * Map的遍历
		 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");

		// 最简洁、最通用的遍历方式
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		// Java5之前的比较简洁的便利方式1
		System.out.println("----1----");
		for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		// Java5之前的比较简洁的便利方式2
		System.out.println("----2----");
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			System.out.println(key + " = " + map.get(key));
		}

		/**
		 * 队列的遍历
		 */
		Queue<Integer> q = new LinkedBlockingQueue<Integer>();
		// 初始化队列
		for (int i = 0; i < 5; i++) {
			q.offer(i);
		}
		System.out.println("-------1-----");
		// 集合方式遍历，元素不会被移除
		for (Integer x : q) {
			System.out.println(x);
		}
		System.out.println("-------2-----");
		// 队列方式遍历，元素逐个被移除
		while (q.peek() != null) {
			System.out.println(q.poll());
		}

		/**
		 * Stack的遍历
		 */
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		// 集合遍历方式
		for (Integer x : s) {
			System.out.println(x);
		}
		System.out.println("------1-----");
		// 栈弹出遍历方式
		// while (s.peek()!=null) { //不健壮的判断方式，容易抛异常，正确写法是下面的
		while (!s.empty()) {
			System.out.println(s.pop());
		}
		System.out.println("------2-----");
		// 错误的遍历方式
		// for (Integer x : s) {
		// System.out.println(s.pop());
		// }
	}
}
