
package leetcode.editor.cn;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 2274, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.Stack;

/**
 * 2024-02-22 21:12:31
 */
public class Ac_98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Ac_98ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {

            long min = Long.MIN_VALUE;
            if (root == null) {
                return true;
            }

            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {

                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                TreeNode pop = stack.pop();
                int value = pop.val;
                if (min >= value) {
                    return false;
                }
                min = value;
                root = pop.right;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}