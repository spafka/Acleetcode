
package leetcode.editor.cn;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
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
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 2245, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 2024-02-23 22:34:06
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {


            List<Integer> collect = Arrays.stream(inorder).boxed().collect(Collectors.toList());
            return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1,
                    collect);
        }

        TreeNode build(int[] preorder, int preorderFrom, int preorderTo,
                       int[] inorder, int inorderFrom, int inorderTo, List<Integer> indexOf) {

            if (preorderFrom > preorderTo) {
                return null;
            }

            TreeNode treeNode = new TreeNode(preorder[preorderFrom]);

            int inorderIndex = indexOf.indexOf(preorder[preorderFrom]);

            int leftSize = inorderIndex - inorderFrom;

            treeNode.left = build(preorder, preorderFrom + 1, preorderFrom + leftSize,
                    inorder,inorderFrom,inorderIndex-1,indexOf );
            treeNode.right = build(preorder,preorderFrom+leftSize+1,preorderTo,
                    inorder,inorderIndex+1,inorderTo,indexOf);
            return treeNode;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}