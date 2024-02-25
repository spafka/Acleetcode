
package leetcode.editor.cn;

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
//
// Related Topics数组 | 回溯 
//
// 👍 1518, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.*;

/**
 * 2024-02-25 21:40:35
 */
public class Ac_40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Ac_40CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            Arrays.sort(candidates);
            backTrack(new LinkedList<>(), 0, candidates, target);
            return res;
        }

        void backTrack(LinkedList<Integer> path, int i, int[] candidates, int target) {

            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (target < 0) {
                return;
            }
            for (int j = i ; j < candidates.length; j++) {

                if (j > i && candidates[j] == candidates[j - 1]) {
                    continue;
                }
                path.add(candidates[j]);
                backTrack(path, j+1, candidates, target - candidates[j]);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}