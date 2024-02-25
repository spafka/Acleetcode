
package leetcode.editor.cn;

//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
// 
// 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
// 
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 723, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-02-25 19:53:13
 */
public class Ac_129SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new Ac_129SumRootToLeafNumbers().new Solution();
        TreeNode treeNode = new Ac_108ConvertSortedArrayToBinarySearchTree.Solution().sortedArrayToBST(new int[]{1, 2, 3});
        solution.sumNumbers(treeNode);
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
        int res = 0;

        public int sumNumbers(TreeNode root) {

            if (root == null) {
                return 0;
            }

            dfs(root, 0);
            return res;
        }

        void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            int sum1 = sum * 10 + root.val;
            if (root.left == null && root.right == null) {
                res += (sum1);
                return;
            }

            dfs(root.left, sum1);
            dfs(root.right, sum1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}