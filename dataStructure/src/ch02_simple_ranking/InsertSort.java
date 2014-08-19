package ch02_simple_ranking;
/**
 * 插入排序
 * @author Andy
 * 插入排序是由一个for循环加上一个while循环。
 * 对于已经有序或者是基本有序的数据来说，插入排序要好的多。当数据有序的时候，
 * while循环的条件总是假，所以它变成外层循环的一个简单语句，执行N-1次。
 * 在这种情况下，算法运行只需要O(N)的时间。
 */
public class InsertSort {
	
	public static void sort(long[] arr) {
		long temp = 0;
		/*
		 * i从1开始！ 也就是拿第二个数据开始往前插
		 */
		for(int i = 1; i < arr.length; i++) {
			temp = arr[i];    //待插入的元素
			int index = i;    
			/*
			 * 这里一定要注意arr[index]>=temp中的=号，不能丢(因为第一次进入到循环体的条件就是等号)
			 */
			while(temp <= arr[index] && index > 0) {
				//比他大的元素右移
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = temp;
		}
	}
}
