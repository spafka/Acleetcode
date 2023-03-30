package leetcode.editor.cn;

//Given two strings word1 and word2, return the minimum number of steps 
//required to make word1 and word2 the same. 
//
// In one step, you can delete exactly one character in either string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make 
//"eat" to "ea".
// 
//
// Example 2: 
//
// 
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 and word2 consist of only lowercase English letters. 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 545, 👎 0 
//
//
//
//


/**
 * 2023-03-14 21:33:44
 */
public class Ac_583DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new Ac_583DeleteOperationForTwoStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {

            // sea
            // eat dp[i][j] 表示word1[0:i],word2[0:j] 的最长公共子序列
            int dp[][] = new int[word1.length()+1][word2.length()+1];


            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1]+1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}