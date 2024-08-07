
package leetcode.editor.cn;

//给定一个二维矩阵 matrix，以下类型的多个请求：
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下
//角 (row2, col2) 所描述的子矩阵的元素 总和 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200
// 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 
// 最多调用 10⁴ 次 sumRegion 方法 
// 
//
// Related Topics设计 | 数组 | 矩阵 | 前缀和 
//
// 👍 568, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-07-07 19:56:13
 */
public class Ac_304RangeSumQuery2dImmutable {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {

        int[][] preSum = null;

        public NumMatrix(int[][] matrix) {

            int m = matrix.length;
            if (m > 0) {
                int n = matrix[0].length;
                preSum = new int[m + 1][n + 1];

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];
                    }
                }

            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            return preSum[row2 + 1][col2 + 1] + preSum[row1][col1]
                    - preSum[row2 + 1][col1] - preSum[row1][col2 + 1];

        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}