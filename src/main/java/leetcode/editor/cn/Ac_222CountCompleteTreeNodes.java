
package leetcode.editor.cn;

//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics位运算 | 树 | 二分查找 | 二叉树 
//
// 👍 1096, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-02-25 20:12:57
 */
public class Ac_222CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new Ac_222CountCompleteTreeNodes().new Solution();
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
        public int countNodes(TreeNode root) {

            if (root == null) {
                return 0;
            }
            TreeNode node = root;

            int l = 0;
            while (node != null) {
                node = node.left;
                l++;
            }

            int r = 0;
            node = root;
            while (node != null) {
                node = node.right;
                r++;
            }
            if (l == r) {
                return 2 << (l) - 1;
            }

            return 1 + countNodes(root.left) + countNodes(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}