/*package ch09_quicksort;

public class QuickSort1 {
	public static void quickSort(int a[],int start,int end){
		int i,j;
		i=start;
		j=end;
		if((a==null)||(a.length==0))
		return;
		while(i<j){
		while(i<j&&a[i]<=a[j]){//������start�±������Ϊkey���Ҳ�ɨ��
		j--;
		}
		if(i<j){//�Ҳ�ɨ�裬�ҳ���һ����keyС�ģ�����λ��
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		}
		while(i<j&&a[i]<a[j]){//���ɨ�裨��ʱa[j]�д洢��keyֵ��
		i++;
		}
		if(i<j){//�ҳ���һ����key��ģ�����λ��
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		}
		}
		if(i-start>1){
		//�ݹ���ã���keyǰ����������
		quickSort(a,start,i-1);
		}
		if(end-i>1){
		quickSort(a,i+1,end);//�ݹ���ã���key������������
		}
		}
		 
		////////////////////////////��ʽ��////////////////////////////////
		����Ч�ʵ�Ĵ��룺
		public <TextendsComparable<?superT>> T[] quickSort(T[] targetArr,
		int start,intend){
		inti=start+1,j=end;
		Tkey=targetArr[start];
		SortUtil<T>sUtil=newSortUtil<T>();
		 
		if(start>=end){
		returntargetArr;
		}
		 
		��i++��j--������������������������ֵ������*
		*����Ϊ��i++����С��key��j--�������key
		while(true){
		while(targetArr[j].compareTo(key)>0){
		j--;
		}
		while(targetArr[i].compareTo(key)<0&&i<j){
		i++;
		}
		if(i>=j){
		break;
		}
		sUtil.swap(targetArr,i,j);
		if(targetArr[i]==key){
		j--;
		}else{
		i++;
		}
		}
		 
		�ؼ����ݷŵ����м䡯
		sUtil.swap(targetArr,start,j);
		 
		if(start<i-1){
		this.quickSort(targetArr,start,i-1);
		}
		if(j+1<end){
		this.quickSort(targetArr,j+1,end);
		}
		 
		returntargetArr;
		}
		 
		////////////////��ʽ�������ٽ������������Ч��/////////////////////
		private<TextendsComparable<?superT>>voidquickSort(T[]targetArr,
		intstart,intend){
		inti=start,j=end;
		Tkey=targetArr[start];
		 
		while(i<j){
		//��j--�������Ŀ�����飬ֱ����keyС��ֵΪֹ
		while(j>i&&targetArr[j].compareTo(key)>=0){
		j--;
		}
		if(i<j){
		//targetArr[i]�Ѿ�������key�У��ɽ������������
		targetArr[i]=targetArr[j];
		}
		//��i++�������Ŀ�����飬ֱ����key���ֵΪֹ
		while(i<j&&targetArr[i].compareTo(key)<=0){//�˴�һ��ҪС�ڵ����㣬��������֮����һ�ڸ�1��0������ֵĻ�����key��ֵ��ǡ����1�Ļ�����ô���С�ڵ��ڵ����þͻ�ʹ�����if�����ִ��һ�ڴΡ�
		i++;
		}
		if(i<j){
		//targetArr[j]�ѱ�����targetArr[i]�У��ɽ�ǰ���ֵ����
		targetArr[j]=targetArr[i];
		}
		}
		//��ʱi==j
		targetArr[i]=key;
		 
		if(i-start>1){
		//�ݹ���ã���keyǰ����������
		this.quickSort(targetArr,start,i-1);
		}
		if(end-j>1){
		//�ݹ���ã���key������������
		this.quickSort(targetArr,j+1,end);
		}
		}
}
*/