//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 1523 👎 0

package io.github.spafka.leetcode.editor.cn;

/**
 * @date 2022-02-04 17:58:51
 * @see {https://leetcode-cn.com/problems/unique-binary-search-trees}
 **/
public class Code_96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new Code_96_UniqueBinarySearchTrees().new Solution();

        solution.numTrees(3);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {

            return count(1, n);
        }

        //[low,high]
        public int count(int low, int high) {
            if (low > high) {
                return 1;
            }

            int res = 0;
            for (int i = low; i <= high; i++) {
                int lef = count(low, i - 1);
                int right = count(i + 1, high);
                res += lef * right;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}