
package leetcode.editor.cn;
  
 //给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics队列 | 数组 | 滑动窗口 | 单调队列 | 堆（优先队列） 
//
// 👍 2721, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**2024-03-10 14:38:29*/
public class Ac_239SlidingWindowMaximum{
      public static void main(String[] args) {
           Solution solution = new Ac_239SlidingWindowMaximum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          /* 单调队列的实现 */
          class MonotonicQueue {
              LinkedList<Integer> maxq = new LinkedList<>();
              public void push(int n) {
                  // 将小于 n 的元素全部删除
                  while (!maxq.isEmpty() && maxq.getLast() < n) {
                      maxq.pollLast();
                  }
                  // 然后将 n 加入尾部
                  maxq.addLast(n);
              }

              public int max() {
                  return maxq.getFirst();
              }

              public void pop(int n) {
                  if (n == maxq.getFirst()) {
                      maxq.pollFirst();
                  }
              }
          }

          /* 解题函数的实现 */
          int[] maxSlidingWindow(int[] nums, int k) {
              MonotonicQueue window = new MonotonicQueue();
              List<Integer> res = new ArrayList<>();

              for (int i = 0; i < nums.length; i++) {
                  if (i < k - 1) {
                      //先填满窗口的前 k - 1
                      window.push(nums[i]);
                  } else {
                      // 窗口向前滑动，加入新数字
                      window.push(nums[i]);
                      // 记录当前窗口的最大值
                      res.add(window.max());
                      // 移出旧数字
                      window.pop(nums[i - k + 1]);
                  }
              }
              // 需要转成 int[] 数组再返回
              int[] arr = new int[res.size()];
              for (int i = 0; i < res.size(); i++) {
                  arr[i] = res.get(i);
              }
              return arr;
          }

      }
//leetcode submit region end(Prohibit modification and deletion)

 }