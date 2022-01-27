package topinterviewquestions;

/**
 * @link {https://leetcode-cn.com/problems/delete-node-in-linked-list/}
 */
public class Problem_0237_DeleteNodeInLinkedList {

	public static class ListNode {
		int val;
		ListNode next;
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}