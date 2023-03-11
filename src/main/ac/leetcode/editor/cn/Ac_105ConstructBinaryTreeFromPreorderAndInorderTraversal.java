package leetcode.editor.cn;

//Given two integer arrays preorder and inorder where preorder is the preorder
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 1896, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.HashMap;

/**
 * 2023-03-11 16:11:06
 */
public class Ac_105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Ac_105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
            // 存储 inorder 中值到索引的映射
            HashMap<Integer, Integer> valToIndex = new HashMap<>();

            public TreeNode buildTree(int[] preorder, int[] inorder) {
                for (int i = 0; i < inorder.length; i++) {
                    valToIndex.put(inorder[i], i);
                }
                return build(preorder, 0, preorder.length - 1,
                        inorder, 0, inorder.length - 1);
            }

            /*
               定义：前序遍历数组为 preorder[preStart..preEnd]，
               中序遍历数组为 inorder[inStart..inEnd]，
               构造这个二叉树并返回该二叉树的根节点
            */
            TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
                if (preStart > preEnd) {
                    return null;
                }

                // root 节点对应的值就是前序遍历数组的第一个元素
                int rootVal = preorder[preStart];
                // rootVal 在中序遍历数组中的索引
                int index = valToIndex.get(rootVal);

                int leftSize = index - inStart;

                // 先构造出当前根节点
                TreeNode root = new TreeNode(rootVal);
                // 递归构造左右子树
                root.left = build(preorder, preStart + 1, preStart + leftSize,
                        inorder, inStart, index - 1);

                root.right = build(preorder, preStart + leftSize + 1, preEnd,
                        inorder, index + 1, inEnd);
                return root;
            }

    }
//leetcode submit region end(Prohibit modification and deletion)

}