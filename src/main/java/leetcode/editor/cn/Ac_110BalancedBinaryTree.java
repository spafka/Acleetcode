
package leetcode.editor.cn;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 1485, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-02-23 23:19:50
 */
public class Ac_110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Ac_110BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return traverse(root).blance;
        }

        Info traverse(TreeNode root) {

            if (root == null) {
                return new Info(true, 0);
            }

            Info l = traverse(root.left);
            Info r = traverse(root.right);

            return new Info(l.blance && r.blance && Math.abs(l.length - r.length) <= 1,
                    Math.max(l.length, r.length) + 1);

        }

        class Info {
            boolean blance;
            int length;

            public Info(boolean b, int l) {
                this.blance = b;
                this.length = l;

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}