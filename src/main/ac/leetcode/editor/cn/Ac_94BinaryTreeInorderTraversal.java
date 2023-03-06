package leetcode.editor.cn;

//Given the root of a binary tree, return the inorder traversal of its nodes'
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1725, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2023-03-06 22:08:46
 */
public class Ac_94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Ac_94BinaryTreeInorderTraversal().new Solution();
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

        List<Integer> res = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            iterInorder(root);
            return res;
        }

        public void iterInorder(TreeNode root) {

            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {

                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }

                TreeNode cur = stack.pop();
                res.add(cur.val);
                root = cur.right;

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}