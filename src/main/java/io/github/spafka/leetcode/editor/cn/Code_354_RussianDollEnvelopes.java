/**
 * <p>给你一个二维整数数组 <code>envelopes</code> ，其中 <code>envelopes[i] = [w<sub>i</sub>, h<sub>i</sub>]</code> ，表示第 <code>i</code> 个信封的宽度和高度。</p>
 *
 * <p>当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。</p>
 *
 * <p>请计算 <strong>最多能有多少个</strong> 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。</p>
 *
 * <p><strong>注意</strong>：不允许旋转信封。</p>
 * &nbsp;
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最多信封的个数为 <code>3, 组合为: </code>[2,3] =&gt; [5,4] =&gt; [6,7]。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>envelopes = [[1,1],[1,1],[1,1]]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= envelopes.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>envelopes[i].length == 2</code></li>
 * <li><code>1 &lt;= w<sub>i</sub>, h<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 动态规划 | 排序</details><br>
 *
 * <div>👍 778, 👎 0</div>
 */
package io.github.spafka.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @date 2022-08-02 20:41:08
 * @see {https://leetcode-cn.com/problems/russian-doll-envelopes}
 **/
public class Code_354_RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new Code_354_RussianDollEnvelopes().new Solution();

        int i = solution.maxEnvelopes(new int[][]{new int[]{1, 2},

                new int[]{2, 2},
                new int[]{4, 3},
                new int[]{3, 3},
                new int[]{3, 5}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {

            // 相同宽度 则高度降序
            int[][] ints = Arrays.stream(envelopes).sorted((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]).toArray(int[][]::new);


            int[] ws = new int[ints.length];
            for (int i = 0; i < ints.length; i++) {
                ws[i] = ints[i][0];
            }

            return lis(ws);


        }


        int lis(int nums[]) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < nums.length; i++) {

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