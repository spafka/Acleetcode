//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1736 👎 0

package io.github.spafka.leetcode.editor.cn;

import java.util.*;

/**
 * @date 2022-02-04 18:26:23
 * @see {https://leetcode-cn.com/problems/combination-sum}
 **/
public class Code_39_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Code_39_CombinationSum().new Solution();

        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Deque<Integer> path = new ArrayDeque<>();
            Arrays.sort(candidates);
            dfs(candidates, 0, target, path);
            return res;
        }

        private void dfs(int[] candidates, int begin, int target, Deque<Integer> path) {
            // target 为负数和 0 的时候不再产生新的孩子结点
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            // 重点理解这里从 begin 开始搜索的语意
            for (int i = begin; i < candidates.length; i++) {
                path.addLast(candidates[i]);
                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                dfs(candidates, i, target - candidates[i], path);
                // 状态重置
                path.removeLast();
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}