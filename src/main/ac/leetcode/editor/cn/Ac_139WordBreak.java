package leetcode.editor.cn;

//Given a string s and a dictionary of strings wordDict, return true if s can
//be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple 
//pen apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划 
//
// 👍 1996, 👎 0 
//
//
//
//


import java.util.Arrays;
import java.util.List;

/**
 * 2023-03-12 16:58:44
 */
public class Ac_139WordBreak {
    public static void main(String[] args) {
        Solution solution = new Ac_139WordBreak().new Solution();

        solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean[] dp = new boolean[s.length() + 1];

            // 以i结尾的能否break
            dp[0] = true;
            // leet
            // 0001

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;

                        break;
                    }
                }
            }
            return dp[s.length()];

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}