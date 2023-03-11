package leetcode.editor.cn;

//Given the root of a complete binary tree, return the number of the nodes in
//the tree. 
//
// According to Wikipedia, every level, except possibly the last, is completely 
//filled in a complete binary tree, and all nodes in the last level are as far 
//left as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.
// 
//
// Design an algorithm that runs in less than O(n) time complexity. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,6]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5 * 10⁴]. 
// 0 <= Node.val <= 5 * 10⁴ 
// The tree is guaranteed to be complete. 
// 
//
// Related Topics树 | 深度优先搜索 | 二分查找 | 二叉树 
//
// 👍 896, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

/**
 * 2023-03-11 17:53:36
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
            int leftH = 0;
            int rightH = 0;
            while (node != null) {
                leftH++;
                node = node.left;
            }
            node = root;
            while (node != null) {
                rightH++;
                node = node.right;
            }
            if (leftH == rightH) {
                return (int) Math.pow(2, leftH ) - 1;
            }


            return 1 + countNodes(root.left) + countNodes(root.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}