package leetcode.editor.cn;

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
//
// Related Topics树 | 二叉搜索树 | 数学 | 动态规划 | 二叉树 
//
// 👍 2127, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2023-03-06 19:52:24
 */
public class Ac_96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new Ac_96UniqueBinarySearchTrees().new Solution();

        int i = solution.numTrees(3);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            return build(1, n);
        }

        public int build(int start, int end) {
            if (start >= end) {
                return 1;
            }

            int s = 0;
            for (int i = start; i <= end; i++) {

                s += (build(start, i) * build(i+1, end));

            }
            return s;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}