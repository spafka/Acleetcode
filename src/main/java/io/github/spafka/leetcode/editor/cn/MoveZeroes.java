package io.github.spafka.leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1361 👎 0


/**
 * 2021-12-27 21:04:33
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
            public void moveZeroes(int[] nums) {
                // 去除 nums 中的所有 0
                // 返回去除 0 之后的数组长度
                int p = removeElement(nums, 0);
                // 将 p 之后的所有元素赋值为 0
                for (; p < nums.length; p++) {
                    nums[p] = 0;
                }
            }

            // 双指针技巧，复用 [27. 移除元素] 的解法。
            int removeElement(int[] nums, int val) {
                int fast = 0, slow = 0;
                while (fast < nums.length) {
                    if (nums[fast] != val) {
                        nums[slow] = nums[fast];
                        slow++;
                    }
                    fast++;
                }
                return slow;
            }


    }


//leetcode submit region end(Prohibit modification and deletion)

}