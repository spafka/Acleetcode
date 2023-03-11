package leetcode.editor.cn;

//Given n pairs of parentheses, write a function to generate all combinations
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3123, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.List;

/**
 * 2023-03-11 19:30:14
 */
public class Ac_22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Ac_22GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<String>();

        public List<String> generateParenthesis(int n) {

            build(0, 0, n, new StringBuilder());

            return res;

        }

        public void build(int l, int r, int n, StringBuilder path) {

            if (l == r && r == n) {
                res.add(path.toString());
            }
            if (l < r) {
                return;
            }

            if (l <= n) {
                path.append("(");
                build(++l, r, n, path);
                path.deleteCharAt(path.length() - 1);
                l--;
            }
            if (r <= n) {
                path.append(")");
                build(l, ++r, n, path);
                path.deleteCharAt(path.length() - 1);
                r--;
            }


        }

        ;
    }
//leetcode submit region end(Prohibit modification and deletion)

}