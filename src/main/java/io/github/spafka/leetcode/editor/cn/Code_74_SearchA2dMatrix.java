package io.github.spafka.leetcode.editor.cn;
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 568 👎 0


/**
 * 2022-02-01 18:13:30
 * $@see{https://leetcode-cn.com/problems/search-a-2d-matrix}
 */
public class Code_74_SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new Code_74_SearchA2dMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int LOW = -1;
            int HIGH = matrix.length - 1;


            while (LOW < HIGH) {

                int mid = (LOW + HIGH + 1) / 2;
                if (matrix[mid][0] <= target) {
                    LOW = mid;
                }else {
                    HIGH = mid - 1;
                }

            }

            if (LOW < 0) {
                return false;
            }

            return binarySearchRow(matrix[LOW], target);

        }

        public boolean binarySearchRow(int[] row, int target) {
            int low = 0, high = row.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}