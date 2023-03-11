package leetcode.editor.cn;
  
 //Given the root of a binary tree, return its maximum depth. 
//
// A binary tree's maximum depth is the number of nodes along the longest path 
//from the root node down to the farthest leaf node. 
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
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1539, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

/**2023-03-11 16:03:05*/
public class Ac_104MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new Ac_104MaximumDepthOfBinaryTree().new Solution();
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
    int maxDepth=-1;
    public int maxDepth(TreeNode root) {

        if (root==null){
            return 0;
        }
        dfs(root,0);

        return maxDepth;


    }


    public void dfs(TreeNode root,int deep){
        if (root==null){
            return;
        }

        deep++;

        dfs(root.left,deep);

        dfs(root.right,deep);

        maxDepth=Math.max(deep,maxDepth);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }