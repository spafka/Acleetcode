package io.github.spafka.leetcode.editor.cn;
//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
// Input: haystack = "hello", needle = "ll"
//Output: 2
// Example 2: 
// Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// Example 3: 
// Input: haystack = "", needle = ""
//Output: 0
// 
// 
// Constraints: 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack and needle consist of only lower-case English characters. 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1230 👎 0

  
  /**
  * 2022-01-29 20:27:46
  * $@see{https://leetcode-cn.com/problems/implement-strstr}
  */
  public class Code_28_ImplementStrstr{
      public static void main(String[] args) {
           Solution solution = new Code_28_ImplementStrstr().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }