package ch10_tree_concept;

/*
 * 二叉树节点
 */
public class Node {
	// 数据项,可以是一个对象甚至是一个数组或Map,这里为了简单起见声明为long
	public long data;
	// 左子节点
	public Node leftChild;
	// 右子节点
	public Node rightChild;

	/**
	 * 构造方法
	 * 
	 * @param data
	 */
	public Node(long data) {
		this.data = data;
	}

}
