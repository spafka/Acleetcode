package leetcode.editor.cn;
  
 //Given the head of a singly linked list where elements are sorted in ascending 
//order, convert it to a height-balanced binary search tree. 
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
// The number of nodes in head is in the range [0, 2 * 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics树 | 二叉搜索树 | 链表 | 分治 | 二叉树 
//
// 👍 812, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

/**2023-03-11 16:48:30*/
public class Ac_109ConvertSortedListToBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new Ac_109ConvertSortedListToBinarySearchTree().new Solution();
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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

 }