package leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2423, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2023-02-27 19:10:23
 */
public class Ac_19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Ac_19RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode fast = head;
            while (n-- > 0) {
                fast = fast.next;
            }
            ListNode dummy = new ListNode(0, head);

            ListNode slow = dummy;
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next=slow.next.next;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}