
package leetcode.editor.cn;

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
//
// Related Topics哈希表 | 字符串 | 回溯 
//
// 👍 2762, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2024-02-25 20:53:18
 */
public class Ac_17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Ac_17LetterCombinationsOfAPhoneNumber().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {

            char[] chars = digits.toCharArray();
            HashMap<Character, Character[]> index = new HashMap<>();

            index.put('2', new Character[]{'a', 'b', 'c'});
            index.put('3', new Character[]{'d', 'e', 'f'});
            index.put('4', new Character[]{'g', 'h', 'i'});
            index.put('5', new Character[]{'j', 'k', 'l'});
            index.put('6', new Character[]{'m', 'n', 'o'});
            index.put('7', new Character[]{'p', 'q', 'r', 's'});
            index.put('8', new Character[]{'t', 'u', 'v'});
            index.put('9', new Character[]{'w', 'x', 'y', 'z'});

            List<String> res = new ArrayList<>();
            if (digits.isEmpty()){
                return res;
            }

            dfs(chars, new char[chars.length], 0, res, index);

            return res;
        }

        private void dfs(char[] chars,
                         char[] currentChar,
                         int i,
                         List<String> res,
                         HashMap<Character, Character[]> index) {

            if (i == currentChar.length) {
                res.add(new String(currentChar));
                return;
            }
            Character[] characters = index.get(chars[i]);

            for (Character character : characters) {
                currentChar[i] = character;
                dfs(chars,currentChar,i+1,res,index);

            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}