
package leetcode.editor.cn;

//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 286, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-02-29 23:43:17
 */
public class Ac_1254NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new Ac_1254NumberOfClosedIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m;
        int n;

        public int closedIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;

            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0 && dfs(grid, i, j)) {
                        res++;
                    }
                }
            }

            return res;
        }


        private boolean dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return false;
            }

            if (grid[i][j] != 0) {
                return true;
            }
            grid[i][j] = 1;
            // 不能短路
            boolean dfs = dfs(grid, i + 1, j);
            boolean dfs1 = dfs(grid, i - 1, j);
            boolean dfs2 = dfs(grid, i, j - 1);
            boolean dfs3 = dfs(grid, i, j + 1);
            return dfs &&
                    dfs1 &&
                    dfs2 &&
                    dfs3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}