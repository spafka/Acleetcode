
package leetcode.editor.cn;

//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 字符串 | 回溯 | 二叉树 
//
// 👍 1098, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.List;

/**
 * 2024-02-22 21:47:11
 */
public class Ac_257BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new Ac_257BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            inorderRecuive(root, new StringBuilder(), res);

            return res;


        }

        private void inorderRecuive(TreeNode root, StringBuilder stringBuilder, List<String> res) {

            if (root == null) {
                return;
            }

            String val = root.val + "";
            stringBuilder.append(val);

            if (root.left == null && root.right == null) {
                res.add(stringBuilder.toString());
            }
            stringBuilder.append("->");
            int length = stringBuilder.length();
            inorderRecuive(root.left, stringBuilder, res);
            stringBuilder.delete(length, stringBuilder.length());

            inorderRecuive(root.right, stringBuilder, res);
            stringBuilder.delete(length, stringBuilder.length());
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}