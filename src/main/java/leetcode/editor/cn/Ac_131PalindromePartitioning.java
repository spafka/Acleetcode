
package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 1734, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-02-27 21:11:41
 */
public class Ac_131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new Ac_131PalindromePartitioning().new Solution();

        solution.partition("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {

            char[] chars = s.toCharArray();
            boolean[][] dp = new boolean[chars.length][chars.length];

            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], true);
            }
            //5*5
            //a[3][4]

            // abcba
            for (int i = chars.length - 2; i >= 0; i--) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }

            //System.out.println( ArrayUtils.toString(dp));


            dfs(dp,s,0,new LinkedList<>());

            return res;


        }

        private void dfs(boolean[][] dp, String s, int i, LinkedList<String> path) {
            if (i==s.length()){
                res.add(new ArrayList<>(path));
                return;
            }
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]){
                    path.add(s.substring(i,j+1));
                    dfs(dp,s,j+1,path);
                    path.removeLast();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}