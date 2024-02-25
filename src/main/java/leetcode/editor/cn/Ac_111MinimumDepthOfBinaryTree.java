
package leetcode.editor.cn;
  
 //给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1156, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**2024-02-23 23:30:14*/
public class Ac_111MinimumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new Ac_111MinimumDepthOfBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Queue<TreeNode> q = new LinkedList();


        q.offer(root);
        while (!q.isEmpty()) {

            int sz = q.size();

            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode h = q.poll();

                if (h.left == null && h.right == null) {
                    return res;
                }
                TreeNode left = h.left;
                if (left != null) q.offer(left);
                TreeNode right = h.right;
                if (right != null) q.offer(right);
                level.add(h.val);
            }

            res++;


        }

        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }