package io.github.spafka.leetcode.editor.cn.tree;
//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues. 
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
//Follow up: Recursive solution is trivial, could you do it iteratively? Related
// Topics 栈 树 深度优先搜索 二叉树 
// 👍 1251 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 2022-01-30 14:59:10
 * $@see{https://leetcode-cn.com/problems/binary-tree-inorder-traversal}
 */
public class Code_94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Code_94_BinaryTreeInorderTraversal().new Solution();
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

        List<Integer> res = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
//            inorderRecurive(root);
//            return res;

            Stack<TreeNode> stack = new Stack<>();


            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;

        }

        public void inorderRecurive(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderRecurive(root.left);
            if (res.add(root.val)) ;
            inorderRecurive(root.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}