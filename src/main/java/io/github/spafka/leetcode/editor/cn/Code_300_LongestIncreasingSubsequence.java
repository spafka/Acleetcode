/**
 * <p>给你一个整数数组 <code>nums</code> ，找到其中最长严格递增子序列的长度。</p>
 *
 * <p><strong>子序列&nbsp;</strong>是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，<code>[3,6,2,7]</code> 是数组 <code>[0,3,1,6,2,2,7]</code> 的子序列。</p>
 * &nbsp;
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [10,9,2,5,3,7,101,18]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,1,0,3,2,3]
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [7,7,7,7,7,7,7]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2500</code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><b>进阶：</b></p>
 *
 * <ul>
 * <li>你能将算法的时间复杂度降低到&nbsp;<code>O(n log(n))</code> 吗?</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>动态规划</li></div></div><br><div><li>👍 2639</li><li>👎 0</li></div>
 */
package io.github.spafka.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @date 2022-07-21 22:45:18
 * @see {https://leetcode-cn.com/problems/longest-increasing-subsequence}
 **/
public class Code_300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code_300_LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // 1 3 2 4
            int dp[] = new int[nums.length];
            Arrays.fill(dp, 1);

            for (int i = 0; i < nums.length; i++) {
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