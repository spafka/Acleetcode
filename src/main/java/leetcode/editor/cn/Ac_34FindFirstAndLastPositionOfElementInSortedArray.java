
package leetcode.editor.cn;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2635, 👎 0 
//
//
//
//


/**
 * 2024-03-10 09:49:09
 */
public class Ac_34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Ac_34FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        solution.searchRange(new int[]{2, 2}, 2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int l = 0;
            int r = nums.length - 1;

            int leftMost = -1;
            while (l <= r) {
                int mid = l + r >>> 1;
                if (nums[mid] == target) {
                    leftMost = mid;
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            l = 0;
            r = nums.length - 1;

            int rightMost = -1;
            while (l <= r) {
                int mid = l + r >>> 1;
                if (nums[mid] == target) {
                    rightMost = mid;
                    l = mid + 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return new int[]{leftMost, rightMost};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}