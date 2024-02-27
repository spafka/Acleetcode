
package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics数组 | 回溯 | 矩阵 
//
// 👍 1773, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-02-26 23:39:19
 */
public class Ac_79WordSearch {
    public static void main(String[] args) {
        Solution solution = new Ac_79WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] visited = null;

        public boolean exist(char[][] board, String word) {

            visited = new boolean[board.length][board[0].length];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (backtrack(board,word,i,j,0)){
                        return true;
                    }
                }
            }

            return false;


        }

        boolean backtrack(char[][] board, String word, int i, int j, int searchIndex) {
            if (searchIndex == word.length()) {
                return true;
            }
            if (i < 0 || j < 0) {
                return false;
            }
            if (i >= board.length || j >= board[0].length) {
                return false;
            }

            if (visited[i][j]) {
                return false;
            }



            if (word.charAt(searchIndex) == board[i][j]) {
                visited[i][j] = true;
                boolean ok = backtrack(board, word, i + 1, j, searchIndex + 1) |
                        backtrack(board, word, i - 1, j, searchIndex + 1) |
                        backtrack(board, word, i, j - 1, searchIndex + 1) |
                        backtrack(board, word, i, j + 1, searchIndex + 1);

                if (ok) {
                    return true;
                } else {
                    visited[i][j] = false;
                    return false;
                }
            }


            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}