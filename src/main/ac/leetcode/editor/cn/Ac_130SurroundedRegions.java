package leetcode.editor.cn;

//Given an m x n matrix board containing 'X' and 'O', capture all regions that
//are 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
//region. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//Explanation: Notice that an 'O' should not be flipped if:
//- It is on the border, or
//- It is adjacent to an 'O' that should not be flipped.
//The bottom 'O' is on the border, so it is not flipped.
//The other three 'O' form a surrounded region, so they are flipped.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 936, 👎 0 
//
//
//
//


/**
 * 2023-03-12 19:25:14
 */
public class Ac_130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new Ac_130SurroundedRegions().new Solution();

        char[][] board = {
                {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int rowSize;
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }




    }
//leetcode submit region end(Prohibit modification and deletion)

}