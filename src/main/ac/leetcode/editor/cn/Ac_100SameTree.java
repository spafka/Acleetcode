package leetcode.editor.cn;

//Given the roots of two binary trees p and q, write a function to check if
//they are the same or not. 
//
// Two binary trees are considered the same if they are structurally identical, 
//and the nodes have the same value. 
//
// 
// Example 1: 
// 
// 
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: p = [1,2], q = [1,null,2]
//Output: false
// 
//
// Example 3: 
// 
// 
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both trees is in the range [0, 100]. 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 977, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.Objects;

/**
 * 2023-03-11 15:59:19
 */
public class Ac_100SameTree {
    public static void main(String[] args) {
        Solution solution = new Ac_100SameTree().new Solution();
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
        public boolean isSameTree(TreeNode p, TreeNode q) {

            if (p == null && q == null) {
                return true;
            }
            if (p != null && q == null) {
                return false;
            }
            if (p == null) {
                return false;
            }

            if (!Objects.equals(p.val, q.val)) {
                return false;
            }

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}