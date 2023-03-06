package leetcode.editor.cn;

//Given the root of a binary tree, return the level order traversal of its
//nodes' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
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
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 1601, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-06 22:17:39
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

            List<List<Integer>> res = new ArrayList<>();

            Deque<TreeNode> deque = new LinkedList();

            if (root == null) {
                return res;
            }

            deque.add(root);

            while (!deque.isEmpty()) {

                ArrayList<Integer> level = new ArrayList<>();

                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = deque.pop();

                    level.add(pop.val);
                    if (pop.left != null) {
                        deque.add(pop.left);
                    }
                    if (pop.right != null) {
                        deque.add(pop.right);
                    }
                }

                res.add(level);

            }


            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}