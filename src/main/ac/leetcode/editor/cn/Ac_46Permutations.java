package leetcode.editor.cn;

//Given an array nums of distinct integers, return all the possible
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
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
//
// Related Topics数组 | 回溯 
//
// 👍 2453, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-11 21:16:24
 */
public class Ac_46Permutations {
    public static void main(String[] args) {
        Solution solution = new Ac_46Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();


        public List<List<Integer>> permute(int[] nums) {

            bactrack(nums, new boolean[nums.length], new LinkedList<>());
            return res;

        }

        void bactrack(int nums[], boolean[] visited, LinkedList<Integer> path) {
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    path.addLast(nums[i]);
                    bactrack(nums, visited, path);
                    path.removeLast();
                    visited[i] = false;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}