package leetcode.editor.cn;
  
 //Given an integer array nums where the elements are sorted in ascending order, 
//convert it to a height-balanced binary search tree. 
//
// 
// Example 1: 
// 
// 
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
// 
//
// Example 2: 
// 
// 
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in a strictly increasing order. 
// 
//
// Related Topics树 | 二叉搜索树 | 数组 | 分治 | 二叉树 
//
// 👍 1251, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

/**2023-03-11 16:42:37*/
public class Ac_108ConvertSortedArrayToBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new Ac_108ConvertSortedArrayToBinarySearchTree().new Solution();
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
    public TreeNode sortedArrayToBST(int[] nums) {


      return   build(nums,0,nums.length-1);


    }

    TreeNode build(int[] numbers,int start,int end){

        if (start>end){
            return null;
        }
        int mid = start + end >> 1;

        TreeNode root = new TreeNode(numbers[mid]);
        root.left=build(numbers,start,mid-1);
        root.right=build(numbers,mid+1,end);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }