package io.github.spafka.leetcode.editor.cn;
//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics 数组 回溯 
// 👍 1746 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2022-01-30 14:47:35
 * $@see{https://leetcode-cn.com/problems/permutations}
 */
public class Code_46_Permutations {
    public static void main(String[] args) {
        Solution solution = new Code_46_Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            if (nums == null || nums.length < 1) {
                return res;
            }
            backtrack(nums, null, res);
            return res;

        }

        public void backtrack(int[] nums, LinkedList<Integer> cur, List<List<Integer>> res) {

            if (cur == null) {
                cur = new LinkedList<>();
            }

            if (cur.size() == nums.length) {
                res.add(new ArrayList<>(cur));
            }

            for (int num : nums) {
                if (!cur.contains(num)) {
                    cur.add(num);
                    backtrack(nums, cur, res);
                    cur.removeLast();
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

