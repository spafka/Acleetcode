package leetcode.editor.cn;

//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p 
//and q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], p = 1, q = 2
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q will exist in the tree. 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 2189, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

/**
 * 2023-03-08 22:53:14
 */
public class Ac_236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new Ac_236LowestCommonAncestorOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


            if (root == null) {
                return null;
            }
            if (root == p || root == q) {
                return root;
            }

            TreeNode l1 = lowestCommonAncestor(root.left, p, q);
            TreeNode l2 = lowestCommonAncestor(root.right, p, q);

            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}