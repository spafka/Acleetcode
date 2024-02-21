
package leetcode.editor.cn;

//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 2040, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2024-02-21 22:29:30
 */
public class Ac_94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Ac_94BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> res = new ArrayList<>();
            //inorderRecurive(root, res);
            inorderIter(root, res);
            return res;

        }

        void inorderRecurive(TreeNode root, List<Integer> res) {

            if (root == null) {
                return;
            }
            inorderRecurive(root.left, res);
            res.add(root.val);
            inorderRecurive(root.right, res);

        }

        /**
         * https://www.bilibili.com/video/BV15K4y1Y7Gz/?vd_source=9c1f5037f963301cba1c8bcd8ff73cdc
         *
         * @param root
         * @return
         */
        void inorderIter(TreeNode root, List<Integer> res) {


            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root = pop.right;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}