package ch02_simple_ranking;
/**
 * ��������
 * @author Andy
 * ������������һ��forѭ������һ��whileѭ����
 * �����Ѿ���������ǻ��������������˵����������Ҫ�õĶࡣ�����������ʱ��
 * whileѭ�����������Ǽ٣�������������ѭ����һ������䣬ִ��N-1�Ρ�
 * ����������£��㷨����ֻ��ҪO(N)��ʱ�䡣
 */
public class InsertSort {
	
	public static void sort(long[] arr) {
		long temp = 0;
		/*
		 * i��1��ʼ�� Ҳ�����õڶ������ݿ�ʼ��ǰ��
		 */
		for(int i = 1; i < arr.length; i++) {
			temp = arr[i];    //�������Ԫ��
			int index = i;    
			/*
			 * ����һ��Ҫע��arr[index]>=temp�е�=�ţ����ܶ�(��Ϊ��һ�ν��뵽ѭ������������ǵȺ�)
			 */
			while(temp <= arr[index] && index > 0) {
				//�������Ԫ������
				arr[index] = arr[index - 1];
				index--;
			}
			arr[index] = temp;
		}
	}
}
