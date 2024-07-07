
package leetcode.editor.cn;

//给定一个整数数组 nums，处理以下类型的多个查询:
//
// 
// 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 使用数组 nums 初始化对象 
// int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 
//right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] ) 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 0 <= i <= j < nums.length 
// 最多调用 10⁴ 次 sumRange 方法 
// 
//
// Related Topics设计 | 数组 | 前缀和 
//
// 👍 637, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


/**
 * 2024-07-07 19:56:23
 */
public class Ac_303RangeSumQueryImmutable {


    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        int preSum[]=null;

        public NumArray(int[] nums) {

            this.preSum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }

        }

        public int sumRange(int left, int right) {

            return preSum[right + 1] - preSum[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}