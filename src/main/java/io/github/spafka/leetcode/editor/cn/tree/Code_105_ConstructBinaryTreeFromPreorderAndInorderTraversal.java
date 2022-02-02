package io.github.spafka.leetcode.editor.cn.tree;
//Given two integer arrays preorder and inorder where preorder is the preorder t
//raversal of a binary tree and inorder is the inorder traversal of the same tree,
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
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1399 👎 0


import io.github.spafka.leetcode.TreeNode;

/**
  * 2022-01-30 16:26:55
  * $@see{https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal}
  */
  public class Code_105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new Code_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,
                          int preStart,
                          int preEnd,
                          int[] inOrder,
                          int inStart,
                          int inEnd
    ) {

        if (preStart > preEnd) {
            return null;
        }


        // 先序遍历 第一个就是root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int index = 0;
        // 找到中序遍历的index，左边为左子树，右边为右子树
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                index=i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = build(preorder, preStart+1,preStart+leftSize,
                inOrder,inStart,index-1);

        root.right = build(preorder,preStart+leftSize+1,preEnd, inOrder,index+1,inEnd);

        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }