package io.github.spafka.leetcode.editor.cn;
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 二叉搜索树 数组 分治 二叉树 
// 👍 895 👎 0


import io.github.spafka.leetcode.BTreePrinter;
import io.github.spafka.leetcode.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * 2021-12-19 10:18:05
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {


            return build(nums, 0, nums.length - 1);
        }

        // 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
        TreeNode build(int[] nums, int left, int right) {
            if (left > right) {
                // 区间为空
                return null;
            }
            // 构造根节点
            // BST 节点左小右大，中间的元素就是根节点
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            // 递归构建左子树
            root.left = build(nums, left, mid - 1);
            // 递归构造右子树
            root.right = build(nums, mid + 1, right);

            return root;
        }
    }

    @Test
    public void print(){
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();

        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});

        BTreePrinter.printNode(treeNode);

        List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal.Solution().levelOrder(treeNode);


    }
//leetcode submit region end(Prohibit modification and deletion)

}