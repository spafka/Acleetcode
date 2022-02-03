package io.github.spafka.leetcode.editor.cn;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 为无重复元素的升序排列数组 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 1321 👎 0

  
  /**
  * 2022-02-01 18:03:37
  * $@see{https://leetcode-cn.com/problems/search-insert-position}
  */
  public class Code_35_SearchInsertPosition{
      public static void main(String[] args) {
           Solution solution = new Code_35_SearchInsertPosition().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

              public int searchInsert(int[] nums, int target) {
                  return left_bound(nums, target);
              }

              // 搜索左侧边界的二分算法
              int left_bound(int[] nums, int target) {
                  if (nums.length == 0) return -1;
                  int left = 0;
                  int right = nums.length; // 注意

                  while (left < right) { // 注意
                      int mid = left + (right - left) / 2;
                      if (nums[mid] == target) {
                          right = mid;
                      } else if (nums[mid] < target) {
                          left = mid + 1;
                      } else if (nums[mid] > target) {
                          right = mid; // 注意
                      }
                  }
                  return left;
              }
          }


//leetcode submit region end(Prohibit modification and deletion)

  }