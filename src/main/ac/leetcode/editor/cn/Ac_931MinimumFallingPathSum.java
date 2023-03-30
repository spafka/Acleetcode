package leetcode.editor.cn;

//Given an n x n array of integers matrix, return the minimum sum of any
//falling path through matrix. 
//
// A falling path starts at any element in the first row and chooses the 
//element in the next row that is either directly below or diagonally left/right. 
//Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
//row + 1, col), or (row + 1, col + 1). 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics数组 | 动态规划 | 矩阵 
//
// 👍 215, 👎 0 
//
//
//
//


import java.util.Arrays;

/**
 * 2023-03-13 22:18:49
 */
public class Ac_931MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new Ac_931MinimumFallingPathSum().new Solution();

        solution.minFallingPathSum(new int[][]{

                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {


            int row = matrix.length;
            int clown = matrix[0].length;


            for (int l = 1; l < row; l++)
                for (int i = 0; i < clown; i++) {

                    if (i == 0 && clown > 1) {
                        matrix[l][i] = matrix[l][i] + Math.min(matrix[l - 1][0], matrix[l-1][1]);
                    } else if (i == clown - 1 && clown > 1) {
                        matrix[l][i] = matrix[l][i] + Math.min(matrix[l - 1][clown - 1], matrix[l-1][clown - 2]);
                    } else {
                        matrix[l][i] = matrix[l][i] + Math.min(Math.min(matrix[l - 1][i], matrix[l - 1][i - 1]), matrix[l - 1][i + 1]);
                    }


                }

            return Arrays.stream(matrix[row - 1]).min().getAsInt();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}