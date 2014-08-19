package ch02_simple_ranking;
/**
 * 冒泡排序
 * @author Andy
 *
 */
public class BubbleSort {
	
	/**
	 * 我的写法
	 * @param arr
	 */
	public static void sort(long[] arr) {
		long temp = 0;
		/*
		 * 冒泡排序：从队列的最左边开始，比较0号位置和1号位置，如果左边大，就让两个变量交换位置，
		 * 如果右边大，就什么也不做。然后比较下一个位置，比较1号位置和2号位置...直到最后arr.length-2
		 * 和arr.length-1号位置。
		 * 如果是从左往右按照上边的排序方式，则每一趟可以比较出当前最大的元素放在数组最后，也就是最大的元素冒泡出来。
		 * 如果是从右向左，则每一趟最小的元素冒泡出来，即每一趟都有一个元素排好序了。
		 * 一共需要比较n-1趟，即arr.length-1趟.
		 * 每一趟需要比较arr.length-1-i(i代表第几趟)次
		 * 效率：
		 * (N-1)+(N-2)+...+1=N*(N-1)/2
		 * 
		 * 冒泡排序有序的元素在右边，所以每次内层循环是从0开始，选择排序有序的元素在左侧，所以每次内层循环是从j开始。
		 */
		for (int i = arr.length - 1; i > 0; i--) {//一共需要比较n-1趟，即arr.length-1趟.
			for (int j = 0; j < i; j++) {         //每一趟需要比较arr.length-1-i(i代表第几趟)次,这里因为外层循环的i设为了arr.length - 1并且每次循环完减一,所以这里j只需要小于1
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}

	private static void swap(long[] arr, int j, int i) {
		long temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/*public static void sort(long[] arr) {
		long tmp = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = arr.length - 1; j > i; j--) {
				if(arr[j] < arr[j - 1]) {
					//进行交换
					tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}*/
}
