package io.github.spafka.leetcode.editor.cn;
//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1449 👎 0


import io.github.spafka.leetcode.ListNode;
import io.github.spafka.leetcode.TreeNode;

/**
 * 2022-01-31 00:39:05
 * $@see{https://leetcode-cn.com/problems/sort-list}
 */
public class Code_148_SortList {
    public static void main(String[] args) {
        Solution solution = new Code_148_SortList().new Solution();

        solution.sortList(TreeNode.fromRange(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            ListNode sorted = merge(list1, list2);
            return sorted;



        }



        public ListNode merge(ListNode node1, ListNode node2) {

            ListNode dummy = new ListNode(0);
            ListNode head=dummy;
            ListNode p1 = node1, p2 = node2;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    dummy.next = p1;
                    p1 = p1.next;

                } else {
                    dummy.next = p2;
                    p2 = p2.next;
                }
                dummy = dummy.next;
            }
            if (p1 != null) {
                dummy.next = p1;
            }
            if (p2 != null) {
                dummy.next = p2;
            }
            return head.next;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}