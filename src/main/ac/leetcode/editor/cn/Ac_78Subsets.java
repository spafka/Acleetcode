package leetcode.editor.cn;

//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1956, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-12 12:52:32
 */
public class Ac_78Subsets {
    public static void main(String[] args) {
        Solution solution = new Ac_78Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0, nums.length, new LinkedList<>());
            return res;
        }

        void backtrack(int[] nums, int begin, int size, LinkedList<Integer> path) {
            if (begin == size) {
                res.add(new ArrayList<>(path));
                return;
            }


            path.addLast(nums[begin]);
            backtrack(nums, begin + 1, size, path);
            path.removeLast();
            backtrack(nums, begin + 1, size, path);


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}