package leetcode.editor.cn;

//You are given an m x n binary matrix grid. An island is a group of 1's (
//representing land) connected 4-directionally (horizontal or vertical.) You may assume 
//all four edges of the grid are surrounded by water. 
//
// The area of an island is the number of cells with a value 1 in the island. 
//
// Return the maximum area of an island in grid. If there is no island, return 0
//. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,
//0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,
//0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]
//]
//Output: 6
//Explanation: The answer is not 11, because the island must be connected 4-
//directionally.
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,0,0,0,0,0,0,0]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] is either 0 or 1. 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 937, 👎 0 
//
//
//
//


/**
 * 2023-03-12 20:42:57
 */
public class Ac_695MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new Ac_695MaxAreaOfIsland().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res, row, clown;

        public int maxAreaOfIsland(int[][] grid) {

            row = grid.length;
            clown = grid[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < clown; j++) {

                    res = Math.max(res, areaOfisLand(grid, i, j));
                }
            }

            return res;
        }

        public int areaOfisLand(int grid[][], int x, int y) {
            if (x < 0 || y < 0 || x >= row || y >= clown || grid[x][y] == 0) {
                return 0;
            }

            grid[x][y] = 0;

            return 1 + areaOfisLand(grid, x - 1, y) +
                    areaOfisLand(grid, x + 1, y) +
                    areaOfisLand(grid, x, y - 1) +
                    areaOfisLand(grid, x, y + 1)
                    ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}