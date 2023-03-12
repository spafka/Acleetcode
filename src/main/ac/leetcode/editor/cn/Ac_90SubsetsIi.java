package leetcode.editor.cn;

//Given an integer array nums that may contain duplicates, return all possible
//subsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
// Example 2: 
// Input: nums = [0]
//Output: [[],[0]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1046, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-12 14:19:18
 */
public class Ac_90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new Ac_90SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new LinkedList<>();
            dfs(false, 0, nums, res, new LinkedList<>());
            return res;
        }

        void dfs(boolean usePre, int index, int nums[], List<List<Integer>> res, LinkedList<Integer> path) {
            if (index == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }


            dfs(false,index+1,nums,res,path);
            if (!usePre && index>0 && nums[index] == nums[index-1] ) {
                return;
            }
            path.add(nums[index]);
            dfs(true, index + 1, nums, res, path);


            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}