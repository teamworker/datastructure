package my_thought_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ����Map��Queue �� Stack�ķ�������ͬ����ͨ��Collection
 * 
 * @date Apr 29, 2014--12:44:31 PM
 * @author Andy
 */
public class Map_Queue_Stack_Traverse {

	public static void main(String[] args) {

		/**
		 * Map�ı���
		 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");

		// ���ࡢ��ͨ�õı�����ʽ
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		// Java5֮ǰ�ıȽϼ��ı�����ʽ1
		System.out.println("----1----");
		for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		// Java5֮ǰ�ıȽϼ��ı�����ʽ2
		System.out.println("----2----");
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			System.out.println(key + " = " + map.get(key));
		}

		/**
		 * ���еı���
		 */
		Queue<Integer> q = new LinkedBlockingQueue<Integer>();
		// ��ʼ������
		for (int i = 0; i < 5; i++) {
			q.offer(i);
		}
		System.out.println("-------1-----");
		// ���Ϸ�ʽ������Ԫ�ز��ᱻ�Ƴ�
		for (Integer x : q) {
			System.out.println(x);
		}
		System.out.println("-------2-----");
		// ���з�ʽ������Ԫ��������Ƴ�
		while (q.peek() != null) {
			System.out.println(q.poll());
		}

		/**
		 * Stack�ı���
		 */
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		// ���ϱ�����ʽ
		for (Integer x : s) {
			System.out.println(x);
		}
		System.out.println("------1-----");
		// ջ����������ʽ
		// while (s.peek()!=null) { //����׳���жϷ�ʽ���������쳣����ȷд���������
		while (!s.empty()) {
			System.out.println(s.pop());
		}
		System.out.println("------2-----");
		// ����ı�����ʽ
		// for (Integer x : s) {
		// System.out.println(s.pop());
		// }
	}
}
