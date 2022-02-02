package io.github.spafka.leetcode.editor.cn.tree;
//You are given the root of a binary search tree (BST), where the values of exac
//tly two nodes of the tree were swapped by mistake. Recover the tree without chan
//ging its structure. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 mak
//es the BST valid.
// 
//
// Example 2: 
//
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 a
//nd 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//Follow up: A solution using O(n) space is pretty straight-forward. Could you d
//evise a constant O(1) space solution? Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 638 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.Stack;

/**
  * 2022-01-30 15:30:14
  * $@see{https://leetcode-cn.com/problems/recover-binary-search-tree}
  */
  public class Code_99_RecoverBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new Code_99_RecoverBinarySearchTree().new Solution();
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
    public void recoverTree(TreeNode root) {


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
                  int val= root.val;
                  root.val=pre.val;
                  pre.val=val;
                  return;
                }
                pre=root;
            }

            root = root.right;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }