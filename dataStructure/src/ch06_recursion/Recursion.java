package ch06_recursion;

public class Recursion {
	public static void main(String[] args) {
		// test2(100);
		test();
	}

	static int count = 100;

	public static void test() {
		if (count == 0) {
			return;
		}
		System.out.println("Hello,World!" + count);
		count--;
		test();
	}

	/**
	 * ��д������������д�ݹ����ȽϺ�
	 * 
	 * @param n
	 */
	public static void test2(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		test2(n - 1);// �ǲ���һ�㶼�����ŵ����Լ���
	}
}
