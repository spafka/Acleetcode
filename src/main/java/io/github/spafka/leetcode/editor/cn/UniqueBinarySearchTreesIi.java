package io.github.spafka.leetcode.editor.cn;
//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 1088 👎 0


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 2022-01-05 22:03:48
 */
public class UniqueBinarySearchTreesIi {
    // todo 回溯?
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            return build(1, n);
        }

        public List<TreeNode> build(int from, int end) {

            List<TreeNode> allTrees = new LinkedList<TreeNode>();
            if (from > end) {
                allTrees.add(null);
                return allTrees;
            }


            for (int i = from; i <= end; i++) {
                List<TreeNode> lc = build(from, i - 1);
                List<TreeNode> rc = build(i + 1, end);
                for (TreeNode left : lc) {
                    for (TreeNode right : rc) {
                        TreeNode currTree = new TreeNode(i);
                        currTree.left = left;
                        currTree.right = right;
                        allTrees.add(currTree);
                    }
                }
            }

            return allTrees;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}