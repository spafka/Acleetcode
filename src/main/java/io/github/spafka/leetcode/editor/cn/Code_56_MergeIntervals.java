package io.github.spafka.leetcode.editor.cn;
//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1287 👎 0


import java.util.*;

/**
 * 2022-01-30 19:48:59
 * $@see{https://leetcode-cn.com/problems/merge-intervals}
 */
public class Code_56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Code_56_MergeIntervals().new Solution();

        solution.merge(new int[][]{new int[]{1, 3}, new int[]{2, 6},
                new int[]{8, 10}, new int[]{15, 18}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] - b[0] < 0) {
                    return -1;
                } else if (a[0] - b[0] == 0) {
                    return a[1] - b[1];
                } else {
                    return 1;
                }
            });

//            final ArrayList<int[]> objects = new ArrayList<>();
//            Arrays.stream(intervals).reduce((a, b) -> {
//                if (a[1] > b[0]) {
//                    objects.add(new int[]{a[0], b[1]});
//                    return new int[]{a[0], b[1]};
//                } else {
//                    objects.add(b);
//                    return b;
//                }
//            });
//            return objects.toArray(new int[objects.size()][]);
            LinkedList<int[]> res = new LinkedList<>();
            res.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] curr = intervals[i];
                // res 中最后一个元素的引用
                int[] last = res.getLast();
                if (curr[0] <= last[1]) {
                    last[1] = Math.max(last[1], curr[1]);
                } else {
                    // 处理下一个待合并区间
                    res.add(curr);
                }
            }
            return res.toArray(new int[0][0]);



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}