package io.github.spafka.leetcode.editor.cn;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 1144 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2022-01-05 23:15:08
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return res;
            }
            Queue<TreeNode> q = new LinkedList();

            // 同一层表示？？int sz = q.size();
            q.offer(root);
            while (!q.isEmpty()) {

                int sz = q.size();

                List<Integer> level = new LinkedList<>();
                for (int i = 0; i < sz; i++) {
                    TreeNode h = q.poll();
                    TreeNode left = h.left;
                    if (left != null) q.offer(left);
                    TreeNode right = h.right;
                    if (right != null) q.offer(right);
                    level.add(h.val);

                }

                res.add(level);

            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}