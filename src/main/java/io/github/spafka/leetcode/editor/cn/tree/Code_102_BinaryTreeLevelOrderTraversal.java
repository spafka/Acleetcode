 package io.github.spafka.leetcode.editor.cn.tree;
//Given the root of a binary tree, return the level order traversal of its nodes
//' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 1165 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 /**
   * 2022-01-30 15:47:34
   * $@see{https://leetcode-cn.com/problems/binary-tree-level-order-traversal}
   */
   public class Code_102_BinaryTreeLevelOrderTraversal {
     public static void main(String[] args) {
         Solution solution = new Code_102_BinaryTreeLevelOrderTraversal().new Solution();
     }
     //leetcode submit region begin(Prohibit modification and deletion)

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
         List<List<Integer>> res = new LinkedList<>();

         public List<List<Integer>> levelOrder(TreeNode root) {
             if (root == null) {
                 return res;
             }
             Queue<TreeNode> q = new LinkedList();

             // 同一层表示？？int sz = q.size();
             q.offer(root);
             while (!q.isEmpty()) {

                 int sz = q.size();

                 List<Integer> level = new LinkedList<>();
                 for (int i = 0; i < sz; i++) {
                     TreeNode h = q.poll();
                     TreeNode left = h.left;
                     if (left != null) q.offer(left);
                     TreeNode right = h.right;
                     if (right != null) q.offer(right);
                     level.add(h.val);

                 }

                 res.add(level);

             }

             return res;

         }

     }


 //leetcode submit region end(Prohibit modification and deletion)
   }
