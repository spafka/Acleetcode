package leetcode.editor.cn;

//Given a string s, find the length of the longest substring without repeating
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 8975, 👎 0 
//
//
//
//


import java.util.HashMap;

/**
 * 2023-03-30 22:32:36
 */
public class Ac_3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Ac_3LongestSubstringWithoutRepeatingCharacters().new Solution();


        int pwwkew = solution.lengthOfLongestSubstring("pwwkew");

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int l = 0, r = 0, length = s.length();
            int res = 0;

            // c,count
            HashMap<Character, Integer> w = new HashMap<>();


            while (r < length) {
                char c = s.charAt(r);
                r++;
                w.put(c, w.getOrDefault(c, 0) + 1);
                while (w.get(c) > 1) {
                    char d = s.charAt(l);
                    l++;
                    w.put(d, w.getOrDefault(d, 0) - 1);

                }
                res = Math.max(r - l, res);

            }

            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}