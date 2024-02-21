
package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics栈 | 树 | 深度优先搜索 | 二叉树
//
// 👍 1229, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2024-02-21 22:03:50
 */
public class Ac_144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Ac_144BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {

//            ArrayList<Integer> res = new ArrayList<>();
//
//            preoderRecrive(root, res);

//            return res;

            return preOderIter(root);
        }


        private void preoderRecrive(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            preoderRecrive(root.left, res);
            preoderRecrive(root.right, res);
        }

        private List<Integer> preOderIter(TreeNode root) {

            ArrayList<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    res.add(root.val);
                    stack.push(root);
                    root = root.left;

                }
                TreeNode pop = stack.pop();

                root = pop.right;
            }

            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}