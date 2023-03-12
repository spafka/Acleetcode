package leetcode.editor.cn;

//Given the root of a binary tree, imagine yourself standing on the right side
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
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
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 827, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2023-03-12 20:56:50
 */
public class Ac_199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new Ac_199BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                        res.add(node.val);
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}