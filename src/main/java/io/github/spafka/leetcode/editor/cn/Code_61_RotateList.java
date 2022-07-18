/**
 * <p>给你一个链表的头节点 <code>head</code> ，旋转链表，将链表每个节点向右移动&nbsp;<code>k</code><em>&nbsp;</em>个位置。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 450px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5], k = 2
 * <strong>输出：</strong>[4,5,1,2,3]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 305px; height: 350px;" />
 * <pre>
 * <strong>输入：</strong>head = [0,1,2], k = 4
 * <strong>输出：</strong>[2,0,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中节点的数目在范围 <code>[0, 500]</code> 内</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * <li><code>0 &lt;= k &lt;= 2 * 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>链表</li><li>双指针</li></div></div><br><div><li>👍 800</li><li>👎 0</li></div>
 */
package io.github.spafka.leetcode.editor.cn;

import io.github.spafka.leetcode.ListNode;
import io.github.spafka.leetcode.TreeNode;

import java.util.TreeMap;

/**
 * @date 2022-07-19 21:42:57
 * @see {https://leetcode-cn.com/problems/rotate-list}
 **/
public class Code_61_RotateList {
    public static void main(String[] args) {
        Solution solution = new Code_61_RotateList().new Solution();

        ListNode listNode = TreeNode.fromRange(5);
        ListNode listNode1 = solution.rotateRight(listNode, 1);

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
        public ListNode rotateRight(ListNode head, int k) {

            if (k == 0 || head == null || head.next == null) {
                return head;
            }
            int n = 1;
            ListNode iter = head;
            while (iter.next != null) {
                iter = iter.next;
                n++;
            }
            int add = n - k % n;
            if (add == n) {
                return head;
            }
            iter.next = head;
            while (add-- > 0) {
                iter = iter.next;
            }
            ListNode ret = iter.next;
            iter.next = null;
            return ret;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}