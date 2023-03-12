package leetcode.editor.cn;

//Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 4
//-directionally connected group of 0s and a closed island is an island totally (
//all left, top, right, bottom) surrounded by 1s. 
//
// Return the number of closed islands. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,
//0,1,0,1],[1,1,1,1,1,1,1,0]]
//Output: 2
//Explanation: 
//Islands in gray are closed because they are completely surrounded by water (
//group of 1s). 
//
// Example 2: 
//
// 
//
// 
//Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,1,1,1,1,1,1],
//               [1,0,0,0,0,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,1,0,1,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,0,0,0,0,1],
//               [1,1,1,1,1,1,1]]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 185, 👎 0 
//
//
//
//


/**
 * 2023-03-12 20:26:38
 */
public class Ac_1254NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new Ac_1254NumberOfClosedIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int row = grid.length;
            int clo = grid[0].length;


            for (int i = 0; i < clo; i++) {
                dfs(grid, 0, i, row, clo);
                dfs(grid, row - 1, i, row, clo);
            }


            for (int i = 0; i < row; i++) {
                dfs(grid, i, 0, row, clo);
                dfs(grid, i, clo - 1, row, clo);
            }

            for (int i = 0; i < clo; i++) {
                dfs(grid, 0, i, row, clo);
                dfs(grid, row - 1, i, row, clo);
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < clo; j++) {

                    if (grid[i][j] == 0) {
                        dfs(grid, i, j, row, clo);
                        res++;
                    }
                }
            }

            return res;
        }

        int res = 0;

        void dfs(int[][] grid, int x, int y, int r, int c) {

            if (x < 0 || y < 0 || x >= r || y >= c) {
                return;
            }

            if (grid[x][y] == 0) {
                grid[x][y] = 1;
                dfs(grid, x, y - 1, r, c);
                dfs(grid, x, y + 1, r, c);
                dfs(grid, x - 1, y, r, c);
                dfs(grid, x + 1, y, r, c);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}