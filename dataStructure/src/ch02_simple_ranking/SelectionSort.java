package ch02_simple_ranking;

public class SelectionSort {
	/**
	 * 选择排序改进了冒泡排序，将必要的交换次数从O(N^2)减少到O(N),
	 * 但是 比较次数仍然保持O(N^2)
	 * 冒泡排序有序的元素在右边，所以每次内层循环是从0开始，
	 * 选择排序有序的元素在左侧，所以每次内层循环是从j开始。
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
