
package leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 990, 👎 0 
//
//
//
//


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 2024-03-10 10:46:08
 */
public class Ac_567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new Ac_567PermutationInString().new Solution();

        solution.checkInclusion("ab", "eidbaooo");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                need.compute(c, (character, integer) -> {
                    if (integer == null) {
                        return 1;
                    } else {
                        return integer + 1;
                    }
                });
            }

            int left = 0;
            int right = 0;
            // ab eidbaooo

            while (right < s2.length()) {
                char c = s2.charAt(right++);
                window.compute(c, (character, integer) -> {
                    if (integer == null) {
                        return 1;
                    } else {
                        return integer + 1;
                    }
                });

                while (right - left > s1.length()) {

                    char remove = s2.charAt(left++);

                    if (window.containsKey(remove) && window.get(remove)==1){
                        window.remove(remove);
                    }else {
                        window.put(remove,window.get(remove)-1);
                    }
                }

                if (window.equals(need)) {
                    return true;
                }
            }
            return false;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}