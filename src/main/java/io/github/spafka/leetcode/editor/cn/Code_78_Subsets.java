/**
 * <p>给你一个整数数组 <code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的子集（幂集）。</p>
 *
 * <p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3]
 * <strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0]
 * <strong>输出：</strong>[[],[0]]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= nums.length <= 10</code></li>
 * <li><code>-10 <= nums[i] <= 10</code></li>
 * <li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
 * </ul>
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 回溯</details><br>
 *
 * <div>👍 1725, 👎 0</div>
 */
package io.github.spafka.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 2022-08-01 20:09:01
 * @see {https://leetcode-cn.com/problems/subsets}
 **/
public class Code_78_Subsets {
    public static void main(String[] args) {
        Solution solution = new Code_78_Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> dummy = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
//
//            List<List<Integer>> res = new LinkedList<>();
//            LinkedList<Integer> dummy = new LinkedList<>();
//            backtrack(nums, res, dummy, 0);

            dfs(0, nums);

            return res;
        }


        // 重复 hash
        public void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> c, int start) {


            res.add(new LinkedList<>(c));


            for (int i = start; i < nums.length; i++) {
                c.add(nums[i]);
                backtrack(nums, res, c, ++start);
                c.removeLast();
            }

        }


        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                res.add(new LinkedList<>(dummy));
                return;
            }
            dummy.add(nums[cur] );
            dfs(cur + 1, nums);

            dummy.removeLast();
            dfs(cur + 1, nums);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}