
package leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics数组 | 动态规划 
//
// 👍 2190, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-03-05 23:27:08
 */
public class Ac_152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new Ac_152MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(int[] nums) {
            int n = nums.length;

            // 定义：以 nums[i] 结尾的子数组，乘积最小为 dp1[i]
            int[] dp1 = new int[n];
            // 定义：以 nums[i] 结尾的子数组，乘积最大为 dp2[i]
            int[] dp2 = new int[n];

            // base case
            dp1[0] = nums[0];
            dp2[0] = nums[0];

            // 状态转移方程
            for (int i = 1; i < n; i++) {
                dp1[i] = min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i], nums[i]);
                dp2[i] = max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i], nums[i]);
            }

            // 遍历所有子数组的最大乘积，求最大值
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp2[i]);
            }

            return res;
        }

        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

        int max(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}