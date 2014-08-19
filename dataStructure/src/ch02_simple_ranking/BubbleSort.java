package ch02_simple_ranking;
/**
 * ð������
 * @author Andy
 *
 */
public class BubbleSort {
	
	/**
	 * �ҵ�д��
	 * @param arr
	 */
	public static void sort(long[] arr) {
		long temp = 0;
		/*
		 * ð�����򣺴Ӷ��е�����߿�ʼ���Ƚ�0��λ�ú�1��λ�ã������ߴ󣬾���������������λ�ã�
		 * ����ұߴ󣬾�ʲôҲ������Ȼ��Ƚ���һ��λ�ã��Ƚ�1��λ�ú�2��λ��...ֱ�����arr.length-2
		 * ��arr.length-1��λ�á�
		 * ����Ǵ������Ұ����ϱߵ�����ʽ����ÿһ�˿��ԱȽϳ���ǰ����Ԫ�ط����������Ҳ��������Ԫ��ð�ݳ�����
		 * ����Ǵ���������ÿһ����С��Ԫ��ð�ݳ�������ÿһ�˶���һ��Ԫ���ź����ˡ�
		 * һ����Ҫ�Ƚ�n-1�ˣ���arr.length-1��.
		 * ÿһ����Ҫ�Ƚ�arr.length-1-i(i����ڼ���)��
		 * Ч�ʣ�
		 * (N-1)+(N-2)+...+1=N*(N-1)/2
		 * 
		 * ð�����������Ԫ�����ұߣ�����ÿ���ڲ�ѭ���Ǵ�0��ʼ��ѡ�����������Ԫ������࣬����ÿ���ڲ�ѭ���Ǵ�j��ʼ��
		 */
		for (int i = arr.length - 1; i > 0; i--) {//һ����Ҫ�Ƚ�n-1�ˣ���arr.length-1��.
			for (int j = 0; j < i; j++) {         //ÿһ����Ҫ�Ƚ�arr.length-1-i(i����ڼ���)��,������Ϊ���ѭ����i��Ϊ��arr.length - 1����ÿ��ѭ�����һ,��������jֻ��ҪС��1
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
					//���н���
					tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}*/
}
