/**
 * <p>给定一个非负整数 <em><code>numRows</code>，</em>生成「杨辉三角」的前 <em><code>numRows</code> </em>行。</p>
 *
 * <p><small>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</small></p>
 *
 * <p><img alt="" src="https://pic.leetcode-cn.com/1626927345-DZmfxB-PascalTriangleAnimated2.gif" /></p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> numRows = 5
 * <strong>输出:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> numRows = 1
 * <strong>输出:</strong> [[1]]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 <= numRows <= 30</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 794</li><li>👎 0</li></div>
 */
package io.github.spafka.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2022-07-21 22:21:44
 * @see {https://leetcode-cn.com/problems/pascals-triangle}
 **/
public class Code_118_PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new Code_118_PascalsTriangle().new Solution();
        List<List<Integer>> generate = solution.generate(3);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Arrays.asList(1));
            for (int i = 1; i < numRows; i++) {
                List<Integer> last = res.get(i - 1);
                List<Integer> level = new ArrayList<>();
                level.add(1);
                for (int j = 1; j < i ; j++) {
                    level.add(last.get(j - 1) + last.get(j));
                }
                level.add(1);
                res.add(level);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}