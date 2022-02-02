package io.github.spafka.leetcode.editor.cn.tree;
//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in he
//ight by no more than 1. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 878 👎 0


import io.github.spafka.leetcode.TreeNode;

/**
  * 2022-01-30 17:36:55
  * $@see{https://leetcode-cn.com/problems/balanced-binary-tree}
  */
  public class Code_110_BalancedBinaryTree{
      public static void main(String[] args) {
           Solution solution = new Code_110_BalancedBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(treehigh(root.left) - treehigh(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    public int treehigh(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(treehigh(node.right), treehigh(node.left)) + 1;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }