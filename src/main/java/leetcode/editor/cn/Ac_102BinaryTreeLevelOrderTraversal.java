
package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 1908, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2024-02-29 23:09:44
 */
public class Ac_102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new Ac_102BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {

            ArrayList<List<Integer>> res = new ArrayList<>();


            Queue<TreeNode> queue = new LinkedList<>();

            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();

                int size = queue.size();
                for (int i = 0; i < size; i++) {

                    TreeNode polled = queue.remove();
                    level.add(polled.val);
                    if (polled.left != null) {
                        queue.offer(polled.left);
                    }
                    if (polled.right != null) {
                        queue.offer(polled.right);
                    }
                }
                res.add(level);
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}