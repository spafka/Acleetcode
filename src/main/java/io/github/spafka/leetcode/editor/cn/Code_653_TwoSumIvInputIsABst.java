/**
 * <p>给定一个二叉搜索树 <code>root</code> 和一个目标结果 <code>k</code>，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 <code>true</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/21/sum_tree_1.jpg" style="height: 229px; width: 400px;" />
 * <pre>
 * <strong>输入:</strong> root = [5,3,6,2,4,null,7], k = 9
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/21/sum_tree_2.jpg" style="height: 229px; width: 400px;" />
 * <pre>
 * <strong>输入:</strong> root = [5,3,6,2,4,null,7], k = 28
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li>二叉树的节点个数的范围是&nbsp;&nbsp;<code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>4</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * <li><code>root</code>&nbsp;为二叉搜索树</li>
 * <li><code>-10<sup>5</sup>&nbsp;&lt;= k &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉搜索树</li><li>哈希表</li><li>双指针</li><li>二叉树</li></div></div><br><div><li>👍 413</li><li>👎 0</li></div>
 */
package io.github.spafka.leetcode.editor.cn;

import io.github.spafka.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022-07-17 19:16:09
 * @see {https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst}
 **/
public class Code_653_TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new Code_653_TwoSumIvInputIsABst().new Solution();
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
        public boolean findTarget(TreeNode root, int k) {

            ArrayList<Integer> list = new ArrayList<>();

            inOrder(root, list);

            int i = 0;
            int j = list.size()-1;

            for (; i < j; ) {
                if (list.get(i) + list.get(j) == k) {
                    return true;
                } else if (list.get(i) + list.get(j) > k) {
                    j--;
                }else if (list.get(i) + list.get(j) <k) {
                   i++;
                }
            }

            return false;

        }


        public void inOrder(TreeNode root, List<Integer> list) {

            if (root == null) {
                return;
            }

            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}