
package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 7087, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-03-02 20:41:18
 */
public class Ac_5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Ac_5LongestPalindromicSubstring().new Solution();


        solution.longestPalindrome("bbcbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            if (s == null || s.length() <= 1) {
                return s;
            }
            int length = s.length();
            boolean[][] dp = new boolean[length][length];

            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }

            int begin = 0;
            int msxLength = 1;
            char[] chars = s.toCharArray();
//            for (int i = length - 2; i >= 0; i--) {
//                for (int j = i + 1; j < length; j++) {
//                    if (chars[i] != chars[j]) {
//                        dp[i][j] = false;
//                    } else {
//                        if (i + 1 > j - 1) {
//                            dp[i][j] = true;
//                        } else {
//                            dp[i][j] = dp[i + 1][j - 1];
//                        }
//                    }
//                    if (dp[i][j] && j - i + 1 > msxLength) {
//
//                        begin = i;
//                        msxLength = j - i + 1;
//                    }
//
//                }
//
//            }

            for (int j = 1; j < length; j++) {
                for (int i = 0; i < j; i++) {

                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        if (i + 1 >= j ) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && j - i + 1 > msxLength) {
                        begin = i;
                        msxLength = j - i + 1;
                    }
                    // System.out.println(i + " " + j);
                }

            }
            return s.substring(begin, begin + msxLength);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}