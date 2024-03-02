
package leetcode.editor.cn;
  
 //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics栈 | 字符串 
//
// 👍 4356, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.Stack;

/**2024-03-02 22:05:22*/
public class Ac_20ValidParentheses{
      public static void main(String[] args) {
           Solution solution = new Ac_20ValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public boolean isValid(String str) {
              Stack<Character> left = new Stack<>();
              for (char c : str.toCharArray()) {
                  if (c == '(' || c == '{' || c == '[')
                      left.push(c);
                  else // 字符 c 是右括号
                      if (!left.isEmpty() && leftOf(c) == left.peek())
                          left.pop();
                      else
                          // 和最近的左括号不匹配
                          return false;
              }
              // 是否所有的左括号都被匹配了
              return left.isEmpty();
          }

          char leftOf(char c) {
              if (c == '}') return '{';
              if (c == ')') return '(';
              return '[';
          }
}
//leetcode submit region end(Prohibit modification and deletion)

 }