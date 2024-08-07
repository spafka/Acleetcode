
package leetcode.editor.cn;
  
 //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 5044, 👎 0 
//
//
//
//


/**2024-03-10 12:37:46*/
public class Ac_42TrappingRainWater{
      public static void main(String[] args) {
           Solution solution = new Ac_42TrappingRainWater().new Solution();

           solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int trap(int[] height) {

              if (height == null || height.length == 0)
                  return 0;
              int ans = 0;
              int size = height.length;
              int[] left_max = new int[size];
              int[] right_max = new int[size];
              left_max[0] = height[0];
              for (int i = 1; i < size; i++) {
                  left_max[i] = Math.max(height[i], left_max[i - 1]);
              }
              right_max[size - 1] = height[size - 1];
              for (int i = size - 2; i >= 0; i--) {
                  right_max[i] = Math.max(height[i], right_max[i + 1]);
              }
              for (int i = 1; i < size - 1; i++) {
                  int ans1 = Math.min(left_max[i], right_max[i]) - height[i];
                  System.out.println(ans1);
                  ans += ans1;
              }
              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

 }