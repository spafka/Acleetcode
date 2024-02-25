
package leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2819, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-02-25 21:47:36
 */
public class Ac_46Permutations {
    public static void main(String[] args) {
        Solution solution = new Ac_46Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {


            backtrack(nums, new LinkedList<Integer>());

            return res;
        }

        private void backtrack(int[] nums, LinkedList<Integer> path) {

            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
            }

            for (int num : nums) {
                if (path.contains(num)) {
                    continue;
                }
                path.add(num);
                backtrack(nums, path);
                path.removeLast();
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}