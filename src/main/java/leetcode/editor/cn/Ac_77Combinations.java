
package leetcode.editor.cn;
  
 //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1589, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**2024-02-26 23:32:24*/
public class Ac_77Combinations{
      public static void main(String[] args) {
           Solution solution = new Ac_77Combinations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<List<Integer>> res = new LinkedList<>();

          public List<List<Integer>> combine(int n, int k) {


              backtrack(1, n, k, new LinkedList<>());
              return res;
          }

          public void backtrack(int index, int n, int k, LinkedList<Integer> path) {

              if (path.size() == k) {
                  res.add(new ArrayList<>(path));
                  return;
              }

              for (int i = index; i <= n; i++) {


                  path.addLast(i);
                  backtrack(i + 1, n, k, path);
                  path.removeLast();
              }

          }
}
//leetcode submit region end(Prohibit modification and deletion)

 }