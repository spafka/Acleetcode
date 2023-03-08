package leetcode.editor.cn;
  
 //Given a binary search tree (BST), find the lowest common ancestor (LCA) node 
//of two given nodes in the BST. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p 
//and q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
// 
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
// 
//
// Example 2: 
// 
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [2,1], p = 2, q = 1
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q will exist in the BST. 
// 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 1032, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

/**2023-03-08 22:47:22*/
public class Ac_235LowestCommonAncestorOfABinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new Ac_235LowestCommonAncestorOfABinarySearchTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //        第一种情况，p和q都在右子树，应该把视角放在右边，去右子树找第三种情况
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
//        第二种情况，p和q都在左子树，应该把视角放在左边，去左子树找第三种情况
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
//        第三种情况，p,q不在同一子树，只能是p，q分别在一左一右，或者，p，q其中一个是根节点，都返回root
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }