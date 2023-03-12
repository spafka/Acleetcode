package leetcode.editor.cn;

//Given an m x n grid of characters board and a string word, return true if
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
//
// Related Topics数组 | 回溯 | 矩阵 
//
// 👍 1547, 👎 0 
//
//
//
//


/**
 * 2023-03-12 13:07:10
 */
public class Ac_79WordSearch {
    public static void main(String[] args) {
        Solution solution = new Ac_79WordSearch().new Solution();

        boolean see = solution.exist(new char[][]{
                {'A', 'B'},
        }, "BA");

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] visited = null;

        public boolean exist(char[][] board, String word) {

            char[] chars = board[0];
            int rowMax = board.length;
            int cloMax = chars.length;
            visited = new boolean[rowMax][cloMax];

            for (int i = 0; i < rowMax; i++) {
                for (int j = 0; j < cloMax; j++) {
                    if (dfs(board, i, j, rowMax, cloMax, word, 0)) {
                        return true;
                    }
                }

            }
            return false;

        }

        private boolean dfs(char[][] board, int x, int y, int rowMax, int cloMax, String word, int index) {
            if (index == word.length()) {
                return true;
            }
            if (x >= rowMax || y >= cloMax || x < 0 || y < 0 || visited[x][y]) {
                return false;
            }

            if (board[x][y] == word.charAt(index)) {
                visited[x][y] = true;

                index++;
                boolean f = dfs(board, x - 1, y, rowMax, cloMax, word, index) ||
                        dfs(board, x + 1, y, rowMax, cloMax, word, index) ||
                        dfs(board, x, y + 1, rowMax, cloMax, word, index) ||
                        dfs(board, x, y - 1, rowMax, cloMax, word, index);

                if (f) {
                    return true;
                } else {

                    visited[x][y] = false;
                    return false;
                }
            }

            return false;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}