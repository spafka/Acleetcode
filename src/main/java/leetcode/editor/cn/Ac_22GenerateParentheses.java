
package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3521, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.List;

/**
 * 2024-02-25 21:08:56
 */
public class Ac_22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Ac_22GenerateParentheses().new Solution();
        solution.generateParenthesis(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {

            if (n == 0) {
                return res;
            }
            backtrack("", 0, 0, n);
            return res;
        }

        public void backtrack(String s, int leftCount, int rightCount, int n) {

            if (leftCount < rightCount) {
                return;
            }
            if (leftCount == rightCount && leftCount == n) {
                res.add(s);
                return;
            }
            if (leftCount <= n) {
                backtrack(s + "(", leftCount + 1, rightCount, n);
                backtrack(s + ")", leftCount, rightCount + 1, n);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}