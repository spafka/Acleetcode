//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 1129 👎 0

package io.github.spafka.leetcode.editor.cn;

/**
 * @date 2022-02-04 20:47:42
 * @see {https://leetcode-cn.com/problems/minimum-path-sum}
 **/
public class Code_64_MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new Code_64_MinimumPathSum().new Solution();
        solution.minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {

            int row = grid.length;
            int clown = grid[0].length;
            int[][] dp = new int[row][clown];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < row; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < clown; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < clown; j++) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
            return dp[row - 1][clown - 1];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}