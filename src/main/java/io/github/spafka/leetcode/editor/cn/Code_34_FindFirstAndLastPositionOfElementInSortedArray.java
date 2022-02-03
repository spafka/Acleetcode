package io.github.spafka.leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
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
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1429 👎 0


/**
 * 2022-02-01 17:48:59
 * $@see{https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array}
 */
public class Code_34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Code_34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();

        solution.searchRange(new int[]{5,7,7,8,8},7);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            return new int[]{leftMost(nums, target), rightMost(nums, target)};
        }


        public int leftMost(int[] nums, int target) {

            int L = 0;
            int R = nums.length - 1;
            int index = -1;

            while (L <= R) {
                int mid = ((L - R) >> 1) + R;
                if (nums[mid] < target) {
                    L = mid + 1;
                } else if (nums[mid] == target) {
                    R = mid-1;
                    index = mid;
                } else {
                    R = mid - 1;
                }

            }
            return index;

        }

        public int rightMost(int[] nums, int target) {
            int L = 0;
            int R = nums.length - 1;
            int index = -1;

            while (L <= R) {
                int mid = ((L - R) >> 1) + R;
                if (nums[mid] < target) {
                    L = mid + 1;
                } else if (nums[mid] == target) {
                    L = mid+1;
                    index = mid;
                } else {
                    R = mid - 1;
                }

            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}