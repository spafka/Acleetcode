//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 816 👎 0

package io.github.spafka.leetcode.editor.cn;

import java.util.*;

/**
 * @date 2022-02-04 18:43:53
 * @see {https://leetcode-cn.com/problems/combination-sum-ii}
 **/
public class Code_40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Code_40_CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if(i > begin && candidates[i] == candidates[i-1]) continue;
                path.addLast(candidates[i]);
                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                dfs(candidates, i + 1, target - candidates[i], path);
                // 状态重置
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}