
package leetcode.editor.cn;

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
// Related Topics树 | 二叉搜索树 | 动态规划 | 回溯 | 二叉树 
//
// 👍 1530, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.List;


/**
 * 2024-02-22 22:15:56
 */
public class Ac_95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new Ac_95UniqueBinarySearchTreesIi().new Solution();
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

        private List<TreeNode> build(int from, int to) {
            List<TreeNode> ans = new ArrayList<>();
            if (from > to) {
                ans.add(null);
                return ans;
            }
            for (int i = from; i <= to; i++) {
                List<TreeNode> left = build(from, i - 1);
                List<TreeNode> right = build(i + 1, to);
                for (TreeNode treeNode : left) {
                    for (TreeNode node : right) {
                        TreeNode root = new TreeNode(i);
                        root.right = node;
                        root.left = treeNode;
                        ans.add(root);
                    }
                }
            }
            return ans;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}