package leetcode.editor.cn;

//You are given two non-empty linked lists representing two non-negative
//integers. The digits are stored in reverse order, and each of their nodes contains a 
//single digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the 
//number 0 itself. 
//
// 
// Example 1: 
// 
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have 
//leading zeros. 
// 
//
// Related Topics递归 | 链表 | 数学 
//
// 👍 9429, 👎 0 
//
//
//
//


/**
 * 2023-03-30 22:22:07
 */
public class Ac_2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Ac_2AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            return add(l1, l2, 0);

        }


        public ListNode add(ListNode l1, ListNode l2, int c) {

            if (l1 == null && l2 == null) {

                if (c != 0) {
                    return new ListNode(c);
                } else {
                    return null;
                }
            }

            if (l1 == null) {
                int val = l2.val;
                int sum = val + c;
                ListNode curr = new ListNode(sum % 10);

                curr.next = add(l1, l2.next, sum / 10);
                return curr;
            }
            if (l2 == null) {
                int val = l1.val;
                int sum = val + c;
                ListNode curr = new ListNode(sum % 10);

                curr.next = add(l1.next, l2, sum / 10);
                return curr;
            }

            int val = l1.val + l2.val;
            int sum = val + c;
            ListNode curr = new ListNode(sum % 10);

            curr.next = add(l1.next, l2.next, sum / 10);
            return curr;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}