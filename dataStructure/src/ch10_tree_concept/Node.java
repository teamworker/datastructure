package ch10_tree_concept;

/*
 * �������ڵ�
 */
public class Node {
	// ������,������һ������������һ�������Map,����Ϊ�˼��������Ϊlong
	public long data;
	// ���ӽڵ�
	public Node leftChild;
	// ���ӽڵ�
	public Node rightChild;

	/**
	 * ���췽��
	 * 
	 * @param data
	 */
	public Node(long data) {
		this.data = data;
	}

}
