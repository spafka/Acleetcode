package leetcode.editor.cn;
  
 //Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the 
//root node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁵]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 948, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

/**2023-03-11 17:17:39*/
public class Ac_111MinimumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new Ac_111MinimumDepthOfBinaryTree().new Solution();
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }