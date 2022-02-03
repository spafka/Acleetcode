package io.github.spafka.leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1523 👎 0


/**
 * 2022-02-02 10:06:05
 * $@see{https://leetcode-cn.com/problems/number-of-islands}
 */
public class Code_200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new Code_200_NumberOfIslands().new Solution();

        solution.numIslands(new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'},

        });

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {

            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        ++res;
                        infect(grid,i,j);

                    }
                }
            }
            return res;
        }

        public void infect(char[][] grid, int x, int y) {

            int xmax = grid.length;
            int ymax = grid[0].length;

            if (!((0 <= x && x < xmax) &&
                    (0 <= y && y < ymax))
            ) {
                return;
            }
            if (grid[x][y] == '1') {
                grid[x][y] = '2';
                infect(grid, x + 1, y);
                infect(grid, x - 1, y);
                infect(grid, x, y - 1);
                infect(grid, x, y + 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}