
package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1540, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-02-25 21:56:02
 */
public class Ac_47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Ac_47PermutationsIi().new Solution();
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