package io.github.spafka.leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1676 👎 0


import java.util.LinkedList;
import java.util.List;

/**
 * 2022-01-09 21:52:46
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 每个数字到字母的映射
        String[] mapping = new String[]{
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> res = new LinkedList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return res;
            }
            // 从 digits[0] 开始进行回溯
            backtrack(digits, 0, new StringBuilder());
            return res;
        }

        // 回溯算法主函数
        void backtrack(String digits, int start, StringBuilder sb) {
            if (sb.length() == digits.length()) {
                // 到达回溯树底部
                res.add(sb.toString());
                return;
            }
            // 回溯算法框架
            for (int i = start; i < digits.length(); i++) {
                int digit = digits.charAt(i) - '0';
                for (char c : mapping[digit].toCharArray()) {
                    // 做选择
                    sb.append(c);
                    // 递归下一层回溯树
                    backtrack(digits, i + 1, sb);
                    // 撤销选择
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}