package io.github.spafka.leetcode.editor.cn.tree;
//Given the root of a binary tree, return its maximum depth. 
//
// A binary tree's maximum depth is the number of nodes along the longest path f
//rom the root node down to the farthest leaf node. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1100 👎 0


import io.github.spafka.leetcode.TreeNode;

/**
  * 2022-01-30 16:15:08
  * $@see{https://leetcode-cn.com/problems/maximum-depth-of-binary-tree}
  */
  public class Code_104_MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new Code_104_MaximumDepthOfBinaryTree().new Solution();
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
    public int maxDepth(TreeNode root) {

        return process(root);
    }


    public int process(TreeNode cur){
        if (cur==null){
            return 0;
        }

        return Math.max(process(cur.left),process(cur.right))+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }