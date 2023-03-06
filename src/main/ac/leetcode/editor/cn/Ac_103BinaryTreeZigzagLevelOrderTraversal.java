package leetcode.editor.cn;
  
 //Given the root of a binary tree, return the zigzag level order traversal of 
//its nodes' values. (i.e., from left to right, then right to left for the next 
//level and alternate between). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 744, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**2023-03-06 22:27:11*/
public class Ac_103BinaryTreeZigzagLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new Ac_103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // 为 true 时向右，false 时向左
            boolean flag = true;

            // while 循环控制从上向下一层层遍历
            while (!q.isEmpty()) {
                int sz = q.size();
                // 记录这一层的节点值
                LinkedList<Integer> level = new LinkedList<>();
                // for 循环控制每一层从左向右遍历
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    // 实现 z 字形遍历
                    if (flag) {
                        level.addLast(cur.val);
                    } else {
                        level.addFirst(cur.val);
                    }
                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
                // 切换方向
                flag = !flag;
                res.add(level);
            }
            return res;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

 }