package leetcode.editor.cn;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 2105, 👎 0 
//
//
//
//


/**
 * 2023-03-12 20:17:25
 */
public class Ac_200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new Ac_200NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int res = 0;

        public int numIslands(char[][] grid) {

            int row = grid.length;
            int clo = grid[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < clo; j++) {

                    if (grid[i][j] == '1') {
                        dfs(grid, i, j, row, clo);
                        res++;
                    }
                }
            }

            return res;

        }

        void dfs(char[][] grid, int x, int y, int r, int c) {

            if (x < 0 || y < 0 || x >= r || y >= c) {
                return;
            }

            if (grid[x][y] == '1') {
                grid[x][y] = '2';
                dfs(grid, x, y - 1, r, c);
                dfs(grid, x, y + 1, r, c);
                dfs(grid, x - 1, y, r, c);
                dfs(grid, x + 1, y, r, c);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}