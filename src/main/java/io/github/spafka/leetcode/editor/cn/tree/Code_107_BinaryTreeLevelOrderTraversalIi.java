package io.github.spafka.leetcode.editor.cn.tree;
//Given the root of a binary tree, return the bottom-up level order traversal of
// its nodes' values. (i.e., from left to right, level by level from leaf to root)
//. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[15,7],[9,20],[3]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 532 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2022-01-30 16:27:55
 * $@see{https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii}
 */
public class Code_107_BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new Code_107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // while 循环控制从上向下一层层遍历
            while (!q.isEmpty()) {
                int sz = q.size();
                // 记录这一层的节点值
                List<Integer> level = new LinkedList<>();
                // for 循环控制每一层从左向右遍历
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    level.add(cur.val);
                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
                // 把每一层添加到头部，就是自底向上的层序遍历。
                res.addFirst(level);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}