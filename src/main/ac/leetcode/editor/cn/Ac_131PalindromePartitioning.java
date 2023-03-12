package leetcode.editor.cn;

//Given a string s, partition s such that every substring of the partition is a
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// 
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 1418, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-12 16:33:53
 */
public class Ac_131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new Ac_131PalindromePartitioning().new Solution();
        List<List<String>> a = solution.partition("aab");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {

            dfs(s, 0, new LinkedList<String>());
            return res;
        }

        private void dfs(String s, int index, LinkedList<String> path) {

            if (index == s.length()) {

                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome(s, index, i)) {
                    path.add(s.substring(index, i + 1));
                    dfs(s, i+1, path);
                    path.removeLast();
                }
            }


        }

        // [start,... end ]
        public boolean isPalindrome(String s, int start, int end) {

            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) {
                    return false;
                }
            }

            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}