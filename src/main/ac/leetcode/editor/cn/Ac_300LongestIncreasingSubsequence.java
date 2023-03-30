package leetcode.editor.cn;

//Given an integer array nums, return the length of the longest strictly
//increasing subsequence. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// Related Topics数组 | 二分查找 | 动态规划 
//
// 👍 3056, 👎 0 
//
//
//
//


import java.util.Arrays;

/**
 * 2023-03-13 21:47:11
 */
public class Ac_300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Ac_300LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {

            // 1 2 1 4
            // 1 2 1 3
            //       i
            // j
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            return Arrays.stream(dp).max().getAsInt();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}