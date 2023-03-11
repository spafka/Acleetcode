package leetcode.editor.cn;

//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1269, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-11 21:00:02
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
            backtrack(candidates, 0, target, new LinkedList<>());
            return res;
        }

        public void backtrack(int[] candidates, int index, int target, LinkedList<Integer> path) {
            if (target < 0 || index > candidates.length) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }

            for (int i = index; i < candidates.length; i++) {

                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                backtrack(candidates, i + 1, target - candidates[i], path);
                path.removeLast();
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}