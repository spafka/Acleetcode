package io.github.spafka.leetcode.editor.cn;
//给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 634 👎 0


import io.github.spafka.leetcode.TreeNode;

/**
 * 2022-01-22 13:07:45
 */
public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
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

        // 分别记录这两个被交换的节点
        TreeNode first = null, second = null;
        // 判断中序遍历的有序性
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);


        public void recoverTree(TreeNode root) {
            inorderTraverse(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraverse(root.left);
            // 中序遍历代码位置，找出那两个节点
            if (root.val < prev.val) {
                // root 不符合有序性
                if (first == null) {
                    // 第一个错位节点是 prev
                    first = prev;
                }
                // 第二个错位节点是 root
                second = root;
            }
            prev = root;
            inorderTraverse(root.right);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}