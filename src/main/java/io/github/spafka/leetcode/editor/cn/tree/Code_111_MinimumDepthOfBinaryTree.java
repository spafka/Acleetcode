package io.github.spafka.leetcode.editor.cn.tree;
//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the roo
//t node down to the nearest leaf node. 
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
// The number of nodes in the tree is in the range [0, 105]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 661 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2022-01-30 17:37:38
 * $@see{https://leetcode-cn.com/problems/minimum-depth-of-binary-tree}
 */
public class Code_111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Code_111_MinimumDepthOfBinaryTree().new Solution();
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
        public int minDepth(TreeNode root) {


            if (root == null) {
                return 0;
            }
            int res = 1;
            Queue<TreeNode> q = new LinkedList();

            // 同一层表示？？int sz = q.size();
            q.offer(root);
            while (!q.isEmpty()) {

                int sz = q.size();

                List<Integer> level = new LinkedList<>();
                for (int i = 0; i < sz; i++) {
                    TreeNode h = q.poll();

                    if (h.left == null && h.right == null) {
                        return res;
                    }
                    TreeNode left = h.left;
                    if (left != null) q.offer(left);
                    TreeNode right = h.right;
                    if (right != null) q.offer(right);
                    level.add(h.val);
                }

                res++;


            }

            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}