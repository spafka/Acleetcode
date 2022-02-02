package io.github.spafka.leetcode.editor.cn;
//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related Topics
// 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1721 👎 0


import io.github.spafka.leetcode.TreeNode;

/**
  * 2022-01-30 15:44:41
  * $@see{https://leetcode-cn.com/problems/symmetric-tree}
  */
  public class Code_101_SymmetricTree{
      public static void main(String[] args) {
           Solution solution = new Code_101_SymmetricTree().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 检查两棵子树是否对称
        return check(root.left, root.right);
    }

    boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        // 两个根节点需要相同
        if (left.val != right.val) return false;
        // 左右子节点需要对称相同
        return check(left.right, right.left) && check(left.left, right.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }