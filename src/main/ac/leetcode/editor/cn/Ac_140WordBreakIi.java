package leetcode.editor.cn;

//Given a string s and a dictionary of strings wordDict, add spaces in s to
//construct a sentence where each word is a valid dictionary word. Return all such 
//possible sentences in any order. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//Output: ["cats and dog","cat sand dog"]
// 
//
// Example 2: 
//
// 
//Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics字典树 | 记忆化搜索 | 数组 | 哈希表 | 字符串 | 动态规划 | 回溯 
//
// 👍 675, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2023-03-12 17:19:13
 */
public class Ac_140WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new Ac_140WordBreakIi().new Solution();

        List<String> strings = solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        // leetcode leet code
        List<String> res = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();

        public List<String> wordBreak(String s, List<String> wordDict) {

            backtrack(s, 0, new StringBuilder(), wordDict);
            return res;
        }


        void backtrack(String s, int index, StringBuilder current, List<String> wordDict) {
            if (current.toString().equals(s)) {
                res.add(String.join(" ", path));
            }

            for (String s1 : wordDict) {
                if (current.length() + s1.length() > s.length()) {
                    continue;
                }
                if (s.substring(index, index + s1.length()).equals(s1)) {
                    current.append(s1);
                    path.add(s1);
                    backtrack(s, index + s1.length(), current, wordDict);
                    current.delete(index, index + s1.length());
                    path.removeLast();
                }

            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}