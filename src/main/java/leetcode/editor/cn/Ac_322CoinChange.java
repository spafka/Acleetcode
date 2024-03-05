
package leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics广度优先搜索 | 数组 | 动态规划 
//
// 👍 2725, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.Arrays;

/**
 * 2024-03-05 23:47:20
 */
public class Ac_322CoinChange {
    public static void main(String[] args) {
        Solution solution = new Ac_322CoinChange().new Solution();
        solution.coinChange(new int[]{1, 2, 5}, 11);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {

            if (amount == 0) {
                return 0;
            }
            int[] dp = new int[amount+1];
            Arrays.fill(dp,amount+1);

            Arrays.sort(coins);
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] < 0) {
                        continue;
                    }
                    if (i - coins[j] == 0) {
                        dp[i] = 1;
                        continue;
                    }
                    int remain = i - coins[j];
                    if (remain > 0) {
                        if (remain >= i) {
                            continue;
                        } else {
                            dp[i] = Math.min(dp[remain] + 1,dp[i]);
                        }
                    }

                }
            }
            return dp[amount ]>amount?-1:dp[amount];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}