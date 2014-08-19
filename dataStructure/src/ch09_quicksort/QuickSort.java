package ch09_quicksort;

/*
 * ��������
 * ��Ҫ�����������A[0]����A[N-1]����������ѡȡһ�����ݣ�ͨ��ѡ������ĵ�һ��������Ϊ�ؼ����ݣ�
 * Ȼ�����б���С�������ŵ���ǰ�棬���б�����������ŵ������棬������̳�Ϊһ�˿�������ֵ��ע����ǣ�
 * ����������һ���ȶ��������㷨��Ҳ����˵�������ͬ��ֵ�����λ��Ҳ������㷨����ʱ�����䶯��
	 һ�˿���������㷨�ǣ�
	 1��������������i��j������ʼ��ʱ��i=0��j=N-1��
	 2���Ե�һ������Ԫ����Ϊ�ؼ����ݣ���ֵ��key����key=A[0]��
	 3����j��ʼ��ǰ���������ɺ�ʼ��ǰ����(j--)���ҵ���һ��С��key��ֵA[j]����A[j]����A[i]��
	 4����i��ʼ�������������ǰ��ʼ�������(i++)���ҵ���һ������key��A[i]����A[i]����A[j]��
	 5���ظ���3��4����ֱ��i=j�� (3,4���У�û�ҵ�����������ֵ����3��A[j]��С��key,4��A[i]������
	   key��ʱ��ı�j��i��ֵ��ʹ��j=j-1��i=i+1��ֱ���ҵ�Ϊֹ���ҵ�����������ֵ�����н�����ʱ��i�� jָ��λ�ò��䡣
	          ���⣬i==j��һ����һ��������i+��j-��ɵ�ʱ�򣬴�ʱ��ѭ����������
 */
public class QuickSort {

	/**
	 * ��������
	 */
	public static int partition(long arr[], int left, int right, long point) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			// ѭ��,���ȹؼ���С���������
			while (leftPtr < rightPtr && arr[++leftPtr] < point)
				;
			// ѭ�������ȹؼ��ִ�������Ҷ�
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
		// ���ؼ��ֺ͵�ǰleftPtr��ָ����һ�����н���
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
			// ���ùؼ���
			long point = arr[right];
			// �������㣬ͬʱ��������л���
			int partition = partition(arr, left, right, point);
			// ����ߵ���������п�������
			sort(arr, left, partition - 1);
			// ���ұߵ���������п�������
			sort(arr, partition + 1, right);
		}
	}
}
