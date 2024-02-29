
package leetcode.editor.cn;

//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
// 
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 260, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-02-29 23:42:30
 */
public class Ac_1020NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new Ac_1020NumberOfEnclaves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m;
        int n;

        public int numEnclaves(int[][] grid) {
            m = grid.length;
            n = grid[0].length;

            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i][j] == '1') {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }

            return res;
        }
        private void dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }

            if (grid[i][j] == '1') {
                grid[i][j] = '2';
            } else {
                return;
            }
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}