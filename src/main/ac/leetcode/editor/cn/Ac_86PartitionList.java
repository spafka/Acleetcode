package leetcode.editor.cn;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 683, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2023-02-27 19:47:58
 */
public class Ac_86PartitionList {
    public static void main(String[] args) {
        Solution solution = new Ac_86PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {

            ListNode small = new ListNode(0);
            ListNode smailTail = small;
            ListNode eq = new ListNode(0);
            ListNode eqTail = eq;
            ListNode bigger = new ListNode(0);
            ListNode bigTail = bigger;
            while (head != null) {
                if (head.val > x) {
                    small.next = head;
                    smailTail = small;
                } else if (head.val < x) {
                    bigger.next = head;
                    bigTail = bigger;
                } else {
                    eq.next = head;
                    eqTail = eq;
                }
                head = head.next;
            }

            smailTail.next=eq.next;
            eqTail.next=bigger.next;

            return small.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}