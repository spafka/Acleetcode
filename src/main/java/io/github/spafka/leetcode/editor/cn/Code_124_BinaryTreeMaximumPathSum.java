package io.github.spafka.leetcode.editor.cn;
//A path in a binary tree is a sequence of nodes where each pair of adjacent nod
//es in the sequence has an edge connecting them. A node can only appear in the se
//quence at most once. Note that the path does not need to pass through the root. 
//
//
// The path sum of a path is the sum of the node's values in the path. 
//
// Given the root of a binary tree, return the maximum path sum of any non-empty
// path. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 
//= 42.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 1396 👎 0


import io.github.spafka.leetcode.TreeNode;

/**
  * 2022-01-30 19:11:55
  * $@see{https://leetcode-cn.com/problems/binary-tree-maximum-path-sum}
  */
  public class Code_124_BinaryTreeMaximumPathSum{
      public static void main(String[] args) {
           Solution solution = new Code_124_BinaryTreeMaximumPathSum().new Solution();
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

        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 计算单边路径和时顺便计算最大路径和
            oneSideMax(root);
            return res;
        }

        // 定义：计算从根节点 root 为起点的最大单边路径和
        int oneSideMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMaxSum = Math.max(0, oneSideMax(root.left));
            int rightMaxSum = Math.max(0, oneSideMax(root.right));
            // 后序遍历位置，顺便更新最大路径和
            int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
            res = Math.max(res, pathMaxSum);
            // 实现函数定义，左右子树的最大单边路径和加上根节点的值
            // 就是从根节点 root 为起点的最大单边路径和
            return Math.max(leftMaxSum, rightMaxSum) + root.val;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }