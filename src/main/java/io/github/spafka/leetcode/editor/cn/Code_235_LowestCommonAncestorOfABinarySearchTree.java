package io.github.spafka.leetcode.editor.cn;
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 748 👎 0


import io.github.spafka.leetcode.TreeNode;

/**
 * 2022-02-01 15:26:25
 * $@see{https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree}
 */
public class Code_235_LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Code_235_LowestCommonAncestorOfABinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) return null;
            if (p.val > q.val) {
                // 保证 p.val <= q.val，便于后续情况讨论
                return lowestCommonAncestor(root, q, p);
            }
            if (root.val >= p.val && root.val <= q.val) {
                // p <= root <= q
                // 即 p 和 q 分别在 root 的左右子树，那么 root 就是 LCA
                return root;
            }
            if (root.val > q.val) {
                // p 和 q 都在 root 的左子树，那么 LCA 在左子树
                return lowestCommonAncestor(root.left, p, q);
            } else {
                // p 和 q 都在 root 的右子树，那么 LCA 在右子树
                return lowestCommonAncestor(root.right, p, q);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}