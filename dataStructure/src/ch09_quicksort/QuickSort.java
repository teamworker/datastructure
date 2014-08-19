package ch09_quicksort;

/*
 * 快速排序：
 * 设要排序的数组是A[0]……A[N-1]，首先任意选取一个数据（通常选用数组的第一个数）作为关键数据，
 * 然后将所有比它小的数都放到它前面，所有比它大的数都放到它后面，这个过程称为一趟快速排序。值得注意的是，
 * 快速排序不是一种稳定的排序算法，也就是说，多个相同的值的相对位置也许会在算法结束时产生变动。
	 一趟快速排序的算法是：
	 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
	 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
	 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]赋给A[i]；
	 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]赋给A[j]；
	 5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于
	   key的时候改变j、i的值，使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。
	          另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。
 */
public class QuickSort {

	/**
	 * 划分数组
	 */
	public static int partition(long arr[], int left, int right, long point) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			// 循环,将比关键字小的留在左端
			while (leftPtr < rightPtr && arr[++leftPtr] < point)
				;
			// 循环，将比关键字大的留在右端
			while (rightPtr > leftPtr && arr[--rightPtr] > point)
				;
			if (leftPtr >= rightPtr) {
				break;
			} else {
				long tmp = arr[leftPtr];
				arr[leftPtr] = arr[rightPtr];
				arr[rightPtr] = tmp;
			}
		}
		// 将关键字和当前leftPtr所指的这一个进行交换
		long tmp = arr[leftPtr];
		arr[leftPtr] = arr[right];
		arr[right] = tmp;
		return leftPtr;
	}

	public static void displayArr(long[] arr) {
		System.out.print("[");
		for (long num : arr) {
			System.out.print(num + " ");
		}
		System.out.print("]");
		System.out.println();
	}

	public static void sort(long[] arr, int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			// 设置关键字
			long point = arr[right];
			// 获得切入点，同时对数组进行划分
			int partition = partition(arr, left, right, point);
			// 对左边的子数组进行快速排序
			sort(arr, left, partition - 1);
			// 对右边的子数组进行快速排序
			sort(arr, partition + 1, right);
		}
	}
}
