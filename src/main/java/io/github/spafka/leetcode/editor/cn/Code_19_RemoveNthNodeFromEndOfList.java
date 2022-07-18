/**
 * <p>给你一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], n = 2
 * <strong>输出：</strong>[1,2,3,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1], n = 1
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>head = [1,2], n = 1
 * <strong>输出：</strong>[1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中结点的数目为 <code>sz</code></li>
 * <li><code>1 &lt;= sz &lt;= 30</code></li>
 * <li><code>0 &lt;= Node.val &lt;= 100</code></li>
 * <li><code>1 &lt;= n &lt;= sz</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你能尝试使用一趟扫描实现吗？</p>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 2133</li><li>👎 0</li></div>
 */
package io.github.spafka.leetcode.editor.cn;

import io.github.spafka.leetcode.ListNode;
import io.github.spafka.leetcode.TreeNode;

/**
 * @date 2022-07-19 21:10:42
 * @see {https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list}
 **/
public class Code_19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new Code_19_RemoveNthNodeFromEndOfList().new Solution();

        ListNode listNode = TreeNode.fromRange(5);
        solution.removeNthFromEnd(listNode, 2);

        System.out.println();

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


            ListNode dummy = new ListNode(0, head);
            ListNode lastN = findLastN(dummy, n + 1);
            lastN.next = lastN.next.next;
            return dummy.next;
        }


        public ListNode findLastN(ListNode head, int k) {

            ListNode f = head;
            for (int i = 0; i < k; i++) {
                f = f.next;
            }

            ListNode s = head;
            while (f != null) {
                s = s.next;
                f = f.next;
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}