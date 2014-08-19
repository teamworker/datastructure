package ch02_simple_ranking;

public class SelectionSort {
	/**
	 * ѡ������Ľ���ð�����򣬽���Ҫ�Ľ���������O(N^2)���ٵ�O(N),
	 * ���� �Ƚϴ�����Ȼ����O(N^2)
	 * ð�����������Ԫ�����ұߣ�����ÿ���ڲ�ѭ���Ǵ�0��ʼ��
	 * ѡ�����������Ԫ������࣬����ÿ���ڲ�ѭ���Ǵ�j��ʼ��
	 * @param arr
	 */
	public static void sort(long[] arr) {
		int min = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, min, i);
		}
	}

	private static void swap(long[] arr, int k, int i) {
		long temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;
	}
}
