package io.github.spafka.leetcode.editor.cn;
//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1339 👎 0


import io.github.spafka.leetcode.BTreePrinter;
import io.github.spafka.leetcode.TreeNode;
import org.junit.Test;

/**
 * 2021-12-19 11:40:38
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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


    @Test
    public void print(){

        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        BTreePrinter.printNode(treeNode);


    }
//leetcode submit region end(Prohibit modification and deletion)

}