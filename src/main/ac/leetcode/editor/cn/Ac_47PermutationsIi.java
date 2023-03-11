package leetcode.editor.cn;

//Given a collection of numbers, nums, that might contain duplicates, return
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1310, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-11 21:29:25
 */
public class Ac_47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Ac_47PermutationsIi().new Solution();

        solution.permuteUnique(new int[]{1,2,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            Arrays.sort(nums);
            bactrack(nums,new boolean[nums.length],new LinkedList<>());

            return res;
        }

        List<List<Integer>> res = new ArrayList<>();


        void bactrack(int nums[], boolean[] visited, LinkedList<Integer> path) {
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    if (i > 0 && nums[i] == nums[i - 1]  && visited[i-1]) {
                        continue;
                    }
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