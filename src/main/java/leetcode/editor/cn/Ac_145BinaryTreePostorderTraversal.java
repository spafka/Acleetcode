
package leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树 
//
// 👍 1162, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 2024-02-21 22:36:09
 */
public class Ac_145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Ac_145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {

            ArrayList<Integer> res = new ArrayList<>();

            // postOrderRecurive(root, res);
            postOrderIter(root, res);

            Collections.reverse(res);
            return res;
        }

        private void postOrderIter(TreeNode root, ArrayList<Integer> res) {
            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    res.add(root.val);
                    root = root.right;
                }

                TreeNode pop = stack.pop();

                root = pop.left;
            }

        }

        private void postOrderRecurive(TreeNode root, ArrayList<Integer> res) {
            if (root == null) {
                return;
            }

            postOrderRecurive(root.left, res);
            postOrderRecurive(root.right, res);

            res.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}