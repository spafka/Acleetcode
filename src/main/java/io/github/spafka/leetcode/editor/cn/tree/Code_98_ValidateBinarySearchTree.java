package io.github.spafka.leetcode.editor.cn.tree;
//Given the root of a binary tree, determine if it is a valid binary search tree
// (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 1399 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.Stack;

/**
  * 2022-01-30 15:23:34
  * $@see{https://leetcode-cn.com/problems/validate-binary-search-tree}
  */
  public class Code_98_ValidateBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new Code_98_ValidateBinarySearchTree().new Solution();
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
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();


        TreeNode pre=null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();


            if (pre==null){
                pre=root;
            }else {
                if (pre.val>=root.val){
                    return false;
                }
                pre=root;
            }

            root = root.right;
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }