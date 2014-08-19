package ch05_doubly_linklist;

import java.util.HashMap;
import java.util.Stack;

/**
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7393134 ���ɸ㶨�����е�������Ŀ
 * http://www.cnblogs.com/jax/archive/2009/12/11/1621504.html �㷨��ȫ��1��������
 * 
 * Ŀ¼��
 * 1. �������н��ĸ���: getListLength
 * 2. ��������ת: reverseList����������reverseListRec���ݹ飩
 * 3. ���ҵ������еĵ�����K����㣨k > 0��: reGetKthNode
 * 4. ���ҵ�������м���: getMiddleNode
 * 5. ��β��ͷ��ӡ������: reversePrintListStack��reversePrintListRec���ݹ飩
 * 6. ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����: mergeSortedList, mergeSortedListRec
 * 7. �ж�һ�����������Ƿ��л�: hasCycle
 * 8. �ж������������Ƿ��ཻ: isIntersect
 * 9. �������������ཻ�ĵ�һ���ڵ�: getFirstCommonNode
 * 10. ��֪һ���������д��ڻ�������뻷�еĵ�һ���ڵ�: getFirstNodeInCycle, getFirstNodeInCycleHashMap
 * 11. ����һ������ͷָ��pHead��һ�ڵ�ָ��pToBeDeleted��O(1)ʱ�临�Ӷ�ɾ���ڵ�pToBeDeleted: delete
 * 
 */
public class Interview {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		printList(n1);
//		System.out.println(getListLength(n1));
//		Node head = reverseList(n1);
//		Node head = reverseListRec(n1);
//		printList(head);

		Node x = reGetKthNode(n1, 2);
		System.out.println(x.val);
		reGetKthNodeRec(n1, 2);
		
		
//		x = getMiddleNode(head);
//		System.out.println(x.val);
//		System.out.println("reversePrintListStack:");
//		reversePrintListStack(head);
//		System.out.println("reversePrintListRec:");
//		reversePrintListRec(head);

	}

	
//	public static void main(String[] args) {
//		Node n1 = new Node(1);
//		Node n2 = new Node(3);
//		Node n3 = new Node(5);
//		n1.next = n2;
//		n2.next = n3;
//
//		Node m1 = new Node(1);
//		Node m2 = new Node(4);
//		Node m3 = new Node(6);
//		m1.next = m2;
//		m2.next = m3;
//		
//		
//		Node ret = mergeSortedList(n1, m1);
//		printList(ret);
//	}

	private static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	// �������н��ĸ���
	// ע���������Ƿ�Ϊ�ա�ʱ�临�Ӷ�ΪO��n��
	public static int getListLength(Node head) {
		// ע��ͷ���Ϊ�����
		if (head == null) {
			return 0;
		}

		int len = 0;
		Node cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}

	// ��ת����������
	// ��ͷ��β����ԭ����ÿ����һ����㣬
	// ����ժ�·������������ǰ�ˡ�
	// ע������Ϊ�պ�ֻ��һ�����������ʱ�临�Ӷ�ΪO��n��
	public static Node reverseList(Node head) {
		// �������Ϊ�ջ�ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���ԭ�����ͷ
		if (head == null || head.next == null) {
			return head;
		}

		Node reHead = null; 		// ��ת��������ָ��
		Node cur = head;

		while (cur != null) {
			Node preCur = cur; 		// ��preCur����ס��Ҫ����ڵ������
			cur = cur.next; 			// cur���µ���һ���ڵ�
			preCur.next = reHead;	// ����Ҫ����ڵ��next����
			reHead = preCur; 			// reHeadָ��Ҫ����ڵ��ǰһ���ڵ�
		}

		return reHead;
	}
	
	// ��ת�ݹ飨�ݹ飩
	// �ݹ�ľ����������Ĭ��reverseListRec�Ѿ��ɹ����������������ˣ�����ȥ����ν����
	// ����ֻҪ����ǰnode��������֮��Ĺ�ϵ��������Բ������������⡣
	/*
		 head
			1 -> 2 -> 3 -> 4
		
		  head
			1--------------
			                    |
	               4 -> 3 -> 2							// Node reHead = reverseListRec(head.next);
	           reHead      head.next
	        
	               4 -> 3 -> 2 -> 1					// head.next.next = head;
	           reHead
	           
	                4 -> 3 -> 2 -> 1 -> null			// head.next = null;
	           reHead
	 */
	public static Node reverseListRec(Node head){
		if(head == null || head.next == null){
			return head;
		}
		
		Node reHead = reverseListRec(head.next);	
		head.next.next = head;		// ��head����reHead�������һ������
		head.next = null;				// ��ֹѭ������
		return reHead;
	}

	/**
	 * ���ҵ������еĵ�����K����㣨k > 0��
	 * ���ձ�ķ����ǣ���ͳ�Ƶ������н��ĸ�����Ȼ�����ҵ��ڣ�n-k������㡣ע������Ϊ�գ�kΪ0��kΪ1��k���������нڵ����ʱ�����
	 * ��ʱ�临�Ӷ�ΪO��n���������ԡ� ������Ҫ��һ����һ��˼·������˼·��������Ŀ��Ҳ����Ӧ�á�
	 * ��Ҫ˼·����ʹ������ָ�룬����ǰ���ָ���ߵ������k�����
	 * ������ǰ������ָ��ľ������k-1��֮��ǰ������ָ��һ����ǰ�ߣ�ǰ���ָ���ߵ����һ�����ʱ������ָ����ָ�����ǵ�����k�����
	 */
	public static Node reGetKthNode(Node head, int k) {
		// ����k�ļ����Ǵ�1��ʼ����kΪ0������Ϊ�շ���null
		if (k == 0 || head == null) {
			return null;
		}

		Node q = head; // q��pǰ��  p--q
		Node p = head; // p��q����

		// ��q����p����k
		while (k > 1 && q != null) {
			q = q.next;
			k--;
		}

		// ���ڵ���С��k������null
		if (k > 1 || q == null) {
			return null;
		}

		// ǰ������ָ��һ���ߣ�ֱ��ǰ���ָ��ָ�����һ���ڵ�
		while (q.next != null) {
			p = p.next;
			q = q.next;
		}

		// ��ǰ���ָ��ָ�����һ���ڵ�ʱ�������ָ��ָ����k���ڵ�
		return p;
	}
	
	
	
	/**
	 * �ݹ��ӡ��������kλ��ֵ
	 * @param head
	 * @param dist
	 */
	static int level = 0;
	public static void reGetKthNodeRec(Node head, int k) {
		
        if(head == null){
            return;
        }
        if(k == 1){
            return;
        }
        
        reGetKthNodeRec(head.next, k);
        level++;
        if(level == k) {
            System.out.println(head.val);
        }
    }
	
	
	

	// ���ҵ�������м���
	/**
	 * �����Ӧ������һ�����Ƶ�˼�롣Ҳ����������ָ�룬ֻ���������ǣ�����ָ��ͬʱ��ǰ�ߣ�ǰ���ָ��ÿ���������������ָ��ÿ����һ����
	 * ǰ���ָ���ߵ����һ�����ʱ�������ָ����ָ�������м��㣬���ڣ�n/2+1������㡣ע������Ϊ�գ����������Ϊ1��2�������ʱ�临�Ӷ�O��n
	 */
	public static Node getMiddleNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node q = head;		// p---q 
		Node p = head;

		// ǰ��ָ��ÿ����������ֱ��ָ�����һ����㣬����ָ��ÿ����һ��
		while (q.next != null) {
			q = q.next;
			p = p.next;
			if (q.next != null) {
				q = q.next;
			}
		}
		return p;
	}

	/**
	 * ��β��ͷ��ӡ������
	 * �������ֵߵ�˳������⣬����Ӧ�þͻ��뵽ջ������ȳ������ԣ���һ��Ҫô�Լ�ʹ��ջ��Ҫô��ϵͳʹ��ջ��Ҳ���ǵݹ顣ע������Ϊ�յ����
	 * ��ʱ�临�Ӷ�ΪO��n��
	 */
	public static void reversePrintListStack(Node head) {
		Stack<Node> s = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			s.push(cur);
			cur = cur.next;
		}

		while (!s.empty()) {
			cur = s.pop();
			System.out.print(cur.val + " ");
		}
		System.out.println();
	}

	/**
	 * ��β��ͷ��ӡ����ʹ�õݹ飨���ţ���
	 */
	public static void reversePrintListRec(Node head) {
		if (head == null) {
			return;
		} else {
			reversePrintListRec(head.next);
			System.out.print(head.val + " ");
		}
	}

	/**
	 * ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����
	 * ������ƹ鲢��������ע����������Ϊ�գ�������һ��Ϊ��ʱ�������ֻ��ҪO��1���Ŀռ䡣ʱ�临�Ӷ�ΪO��max(len1, len2)��
	 */
	public static Node mergeSortedList(Node head1, Node head2) {
		// ����һ������Ϊ�յ������ֱ�ӷ�����һ������ͷ��O(1)
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		Node mergeHead = null;
		// ��ȷ������mergeHead��������
		if (head1.val < head2.val) {
			mergeHead = head1;
			head1 = head1.next; 		// �����Ѿ��ϲ��˵�Ԫ��
			mergeHead.next = null; 	// �Ͽ�mergeHead�ͺ������ϵ
		} else {
			mergeHead = head2;
			head2 = head2.next;
			mergeHead.next = null;
		}

		Node mergeCur = mergeHead;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				mergeCur.next = head1; 		 // ���ҵ���С��Ԫ�غϲ���merge��
				head1 = head1.next;				 // �����Ѿ��ϲ��˵�Ԫ��
				mergeCur = mergeCur.next;	 // �ҵ���һ��׼���ϲ���Ԫ��
				mergeCur.next = null;			 // �Ͽ�mergeCur�ͺ������ϵ
			} else {
				mergeCur.next = head2;
				head2 = head2.next;
				mergeCur = mergeCur.next;
				mergeCur.next = null;
			}
		}

		// �ϲ�ʣ���Ԫ��
		if (head1 != null) {
			mergeCur.next = head1;
		} else if (head2 != null) {
			mergeCur.next = head2;
		}

		return mergeHead;
	}

	/**
	 * �ݹ�ϲ����������ţ���
	 */
	public static Node mergeSortedListRec(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		Node mergeHead = null;
		if (head1.val < head2.val) {
			mergeHead = head1;
			// �����ѽ����������
			mergeHead.next = mergeSortedListRec(head1, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = mergeSortedListRec(head1, head2);
		}
		return mergeHead;
	}

	/**
	 * �ж�һ�����������Ƿ��л�
	 * ����Ҳ���õ�����ָ�롣���һ���������л���Ҳ����˵��һ��ָ��ȥ����������Զ�߲���ͷ�ġ���ˣ����ǿ���������ָ��ȥ������һ��ָ��һ��������
	 * ��һ��ָ��һ����һ��������л�������ָ��϶����ڻ���������ʱ�临�Ӷ�ΪO��n��
	 */
	public static boolean hasCycle(Node head) {
		Node fast = head; // ��ָ��ÿ��ǰ������
		Node slow = head; // ��ָ��ÿ��ǰ��һ��

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) { // ���������ڻ�
				return true;
			}
		}
		return false;
	}

	// �ж������������Ƿ��ཻ
	/**
	 * ������������ཻ��ĳһ�ڵ㣬��ô������ཻ�ڵ�֮������нڵ㶼���������������еġ� Ҳ����˵��������������ཻ����ô���һ���ڵ�϶��ǹ��еġ�
	 * �ȱ�����һ��������ס���һ���ڵ㣬Ȼ������ڶ������� �����һ���ڵ�ʱ�͵�һ����������һ���ڵ����Ƚϣ������ͬ�����ཻ��
	 * �����ཻ��ʱ�临�Ӷ�ΪO(len1+len2)����Ϊֻ��Ҫһ������ָ�뱣�����һ���ڵ��ַ�� �ռ临�Ӷ�ΪO(1)
	 */
	public static boolean isIntersect(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return false;
		}

		Node tail1 = head1;
		// �ҵ�����1�����һ���ڵ�
		while (tail1.next != null) {
			tail1 = tail1.next;
		}

		Node tail2 = head2;
		// �ҵ�����2�����һ���ڵ�
		while (tail2.next != null) {
			tail2 = tail2.next;
		}

		return tail1 == tail2;
	}

	/**
	 * �������������ཻ�ĵ�һ���ڵ� �Ե�һ��������������㳤��len1��ͬʱ�������һ���ڵ�ĵ�ַ��
	 * �Եڶ���������������㳤��len2��ͬʱ������һ���ڵ��Ƿ�͵�һ����������һ���ڵ���ͬ��������ͬ�����ཻ��������
	 * �����������ͷ�ڵ㿪ʼ������len1����len2
	 * ����ô����һ�������ȱ���len1-len2���ڵ㣬��ʱ��������ǰ�ڵ㵽��һ���ཻ�ڵ�ľ��������ˣ�Ȼ��һ����������ֱ�������ڵ�ĵ�ַ��ͬ��
	 * ʱ�临�Ӷȣ�O(len1+len2)
	 * 
	 *    			----    len2
	 *         			 |__________
	 *       			 |
	 *       ---------   len1
	 *       |---|<- len1-len2
	 */
	public static Node getFirstCommonNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		int len1 = 1;
		Node tail1 = head1;
		while (tail1.next != null) {
			tail1 = tail1.next;
			len1++;
		}

		int len2 = 1;
		Node tail2 = head2;
		while (tail2.next != null) {
			tail2 = tail2.next;
			len2++;
		}

		// ���ֱཻ�ӷ���NULL
		if (tail1 != tail2) {
			return null;
		}

		Node n1 = head1;
		Node n2 = head2;

		// �Թ��ϳ��������Ĳ���
		if (len1 > len2) {
			int k = len1 - len2;
			while (k != 0) {
				n1 = n1.next;
				k--;
			}
		} else {
			int k = len2 - len1;
			while (k != 0) {
				n2 = n2.next;
				k--;
			}
		}

		// һ����������ֱ���ҵ�����
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

	/**
	 * ����뻷�еĵ�һ���ڵ� �ÿ���ָ��������������Crack the Coding Interview�Ľⷨ����Ϊ������׶�����
	 */
	public static Node getFirstNodeInCycle(Node head) {
		Node slow = head;
		Node fast = head;

		// 1�� �ҵ�����ָ��������
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // Collision
				break;
			}
		}

		// �����飬����û�л������
		if (fast == null || fast.next == null) {
			return null;
		}

		// 2�����ڣ��������뻷�Ŀ�ʼ���ľ����������ͷ������ʼ���ľ��룬
		// ���������ǰ���ָ���������ͷ����ָ�뱣���������㣬Ȼ��
		// ͬ�ٶ�ǰ�����ٴ���������ǻ��Ŀ�ʼ����
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// �ٴ���������ǻ��Ŀ�ʼ��
		return fast;
	}

	/**
	 * ����뻷�еĵ�һ���ڵ� ��HashMap�� һ���޻���������ÿ�����ĵ�ַ���ǲ�һ���ġ�
	 * ������л���ָ�����������ƶ��������ָ�����ջ�ָ��һ���Ѿ����ֹ��ĵ�ַ �Ե�ַΪ��ϣ��ļ�ֵ��ÿ����һ����ַ���ͽ��ü�ֵ��Ӧ��ʵֵ��Ϊtrue��
	 * ��ô��ĳ����ֵ��Ӧ��ʵֵ�Ѿ�Ϊtrueʱ��˵�������ַ֮ǰ�Ѿ����ֹ��ˣ� ֱ�ӷ�������OK��
	 */
	public static Node getFirstNodeInCycleHashMap(Node head) {
		HashMap<Node, Boolean> map = new HashMap<Node, Boolean>();
		while (head != null) {
			if (map.get(head) == true) {
				return head; // �����ַ֮ǰ�Ѿ����ֹ��ˣ����ǻ��Ŀ�ʼ��
			} else {
				map.put(head, true);
				head = head.next;
			}
		}
		return head;
	}

	/**
	 * ����һ������ͷָ��head��һ�ڵ�ָ��toBeDeleted��O(1)ʱ�临�Ӷ�ɾ���ڵ�tBeDeleted
	 * ����ɾ���ڵ㣬������ͨ��˼·�����øýڵ��ǰһ���ڵ�ָ��ýڵ����һ���ڵ�
	 * �����������Ҫ�����ҵ��ýڵ��ǰһ���ڵ㣬ʱ�临�Ӷ�ΪO(n)����������
	 * �����е�ÿ���ڵ�ṹ����һ���ģ��������ǿ��԰Ѹýڵ����һ���ڵ�����ݸ��Ƶ��ýڵ�
	 * ��Ȼ��ɾ����һ���ڵ㼴�ɡ�Ҫע�����һ���ڵ����������ʱ��ֻ���ó����ķ��������������ҵ�ǰһ���ڵ㣬�������ƽ��ʱ�临�ӶȻ���O(1)
	 */
	public void delete(Node head, Node toDelete){
		if(toDelete == null){
			return;
		}
		if(toDelete.next != null){			// Ҫɾ������һ���м�ڵ�
			toDelete.val = toDelete.next.val;		// ����һ���ڵ�����ݸ��Ƶ����ڵ�!
			toDelete.next = toDelete.next.next;
		}
		else{		// Ҫɾ���������һ���ڵ㣡
			if(head == toDelete){		// ������ֻ��һ���ڵ�����  
				head = null;
			}else{
				Node node = head;
				while(node.next != toDelete){	// �ҵ������ڶ����ڵ�
					node = node.next;
				}
				node.next = null;
			}
		}
	}
	
}
