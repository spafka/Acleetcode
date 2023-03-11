package leetcode.editor.cn;

//Given a string containing digits from 2-9 inclusive, return all possible
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics哈希表 | 字符串 | 回溯 
//
// 👍 2351, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.List;

/**
 * 2023-03-11 19:08:27
 */
public class Ac_17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Ac_17LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] cc = new char[][]{
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}


        };

        public List<String> letterCombinations(String digits) {

            List<String> res = new ArrayList<>();

            if (digits == null || digits.isEmpty()) {
                return res;
            }

            char[] chars = digits.toCharArray();

            back(chars, 0, chars.length , new StringBuilder(), res);

            return res;

        }

        void back(char[] chars, int index, int end, StringBuilder path, List<String> res) {


            if (index == end) {
                res.add(path.toString());
                return;
            }
            char aChar = chars[index];
            char[] chars1 = cc[aChar-'0'];

            for (char c : chars1) {

                StringBuilder append = path.append(c);
                back(chars, ++index, end, append, res);
                index--;
                path.deleteCharAt(index);

            }


        }

        ;
    }
//leetcode submit region end(Prohibit modification and deletion)

}