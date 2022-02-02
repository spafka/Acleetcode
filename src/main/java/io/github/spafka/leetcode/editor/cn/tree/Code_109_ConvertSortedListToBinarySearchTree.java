package io.github.spafka.leetcode.editor.cn.tree;
//Given the head of a singly linked list where elements are sorted in ascending 
//order, convert it to a height balanced BST. 
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
//n which the depth of the two subtrees of every node never differ by more than 1.
// 
//
// 
// Example 1: 
//
// 
//Input: head = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the 
//shown height balanced BST.
// 
//
// Example 2: 
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
// The number of nodes in head is in the range [0, 2 * 104]. 
// -105 <= Node.val <= 105 
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 
// 👍 652 👎 0


import io.github.spafka.leetcode.BTreePrinter;
import io.github.spafka.leetcode.ListNode;
import io.github.spafka.leetcode.TreeNode;
import org.junit.Test;


/**
 * 2022-01-30 16:30:10
 * $@see{https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree}
 */
public class Code_109_ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Code_109_ConvertSortedListToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {

            return build(head, null);

        }


        public TreeNode build(ListNode start, ListNode end) {
            if (start == end) {
                return null;
            }

            ListNode slow = start;
            ListNode fast = start;

            while (fast != null && fast != end && fast.next != end) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return new TreeNode(slow.val, build(start, slow), build(slow.next, end));

        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void Test() {

        final ListNode listNode = TreeNode.fromRange(20);

        final TreeNode treeNode = new Code_109_ConvertSortedListToBinarySearchTree().new Solution().sortedListToBST(listNode);

        BTreePrinter.printNode(treeNode);

    }

}