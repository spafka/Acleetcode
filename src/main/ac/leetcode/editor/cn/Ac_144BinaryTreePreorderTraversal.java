package leetcode.editor.cn;

//Given the root of a binary tree, return the preorder traversal of its nodes'
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
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
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1015, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2023-03-05 21:41:28
 */
public class Ac_144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Ac_144BinaryTreePreorderTraversal().new Solution();

        Ac_297SerializeAndDeserializeBinaryTree.Codec codec = new Ac_297SerializeAndDeserializeBinaryTree.Codec();

        TreeNode root = codec.deserialize("1,2,3,4,5,6,7,8,9");

        solution.preorderTraversal(root);

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
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            //recursive(root, res);
            intr(root, res);
            return res;
        }

        public void recursive(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            recursive(root.left, res);
            recursive(root.left, res);

        }

        public void intr(TreeNode root, List<Integer> res) {

            Stack<TreeNode> stack = new Stack<>();

            while (root != null || !stack.isEmpty()) {

                while (root != null) {
                    stack.push(root);
                    res.add(root.val);
                    root = root.left;
                }

                root = stack.pop();
                root = root.right;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    }


