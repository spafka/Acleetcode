package leetcode.editor.cn;

//You are given the root of a binary search tree (BST), where the values of
//exactly two nodes of the tree were swapped by mistake. Recover the tree without 
//changing its structure. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 
//makes the BST valid.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 
//and 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//Follow up: A solution using 
//O(n) space is pretty straight-forward. Could you devise a constant 
//O(1) space solution?
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 836, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.Stack;

/**
 * 2023-03-07 23:20:00
 */
public class Ac_99RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Ac_99RecoverBinarySearchTree().new Solution();
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
        public void recoverTree(TreeNode root) {

            TreeNode x = null, y = null, pre = null, next = null;
            Stack<TreeNode> stack = new Stack<>();

            while (root != null || !stack.isEmpty()) {

                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }


                root = stack.pop();

                if (pre != null && pre.val >= root.val) {

                    y = root;
                    if (x == null) {
                        x = pre;
                    } else {
                        break;
                    }

                }
                pre = root;
                root = root.right;

            }

            swap(x, y);

        }

        public void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}