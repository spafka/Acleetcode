/**
 * <p>给定两个整数 <code>n</code> 和 <code>k</code>，返回范围 <code>[1, n]</code> 中所有可能的 <code>k</code> 个数的组合。</p>
 *
 * <p>你可以按 <strong>任何顺序</strong> 返回答案。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 4, k = 2
 * <strong>输出：</strong>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 1, k = 1
 * <strong>输出：</strong>[[1]]</pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= n <= 20</code></li>
 * <li><code>1 <= k <= n</code></li>
 * </ul>
 * <details><summary><strong>Related Topics</strong></summary>回溯</details><br>
 *
 * <div>👍 1068, 👎 0</div>
 */
package io.github.spafka.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 2022-08-01 20:33:14
 * @see {https://leetcode-cn.com/problems/combinations}
 **/
public class Code_77_Combinations {
    public static void main(String[] args) {
        Solution solution = new Code_77_Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> c = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            dfs(nums, 0,0, k);
            return res;
        }

        public void dfs(int[] nums,int start, int cc, int k) {

            if (cc == k) {
                res.add(new LinkedList<>(c));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                cc++;
                c.add(nums[i]);
                dfs(nums,++start,cc,k);
                c.removeLast();
                cc--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}