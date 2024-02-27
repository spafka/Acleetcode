
package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2252, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-02-26 23:33:39
 */
public class Ac_78Subsets {
    public static void main(String[] args) {
        Solution solution = new Ac_78Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {


            backtrack(new LinkedList<>(), nums, 0);

            return res;
        }

        void backtrack(LinkedList<Integer> path, int[] nums, int index) {
            if (index == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            path.add(nums[index]);

            backtrack(path, nums, index + 1);
            path.removeLast();
            backtrack(path, nums, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}