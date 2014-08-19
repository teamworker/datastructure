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
	 * 先写结束条件，再写递归代码比较好
	 * 
	 * @param n
	 */
	public static void test2(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		test2(n - 1);// 是不是一般都是最后才调用自己啊
	}
}
