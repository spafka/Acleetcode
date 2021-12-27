package io.github.spafka.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
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
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4506 👎 0


/**
 * 2021-12-26 18:45:03
 */
public class LongestPalindromicSubstring {
    // todo dp
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            int length = s.length();
            String res = "";
            for (int i = 0; i < length; i++) {

                String sub1 = v(s, i, i + 1);
                String sub2 = v(s, i, i);
                res = res.length() > sub1.length() ? res : sub1;
                res = res.length() > sub2.length() ? res : sub2;
            }

            return res;

        }


        // abc
        public String v(String chars, int l, int r) {
           // l<=r
            while (l >= 0 && r < chars.length() && chars.charAt(l) == chars.charAt(r)) {
                l--;
                r++;
            }
            // l--了，这里+1
            return chars.substring(l+1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}