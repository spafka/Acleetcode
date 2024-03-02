
package leetcode.editor.cn;

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics树 | 二叉搜索树 | 数学 | 动态规划 | 二叉树 
//
// 👍 2455, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.HashMap;
import java.util.Map;

/**
 * 2024-03-03 00:44:23
 */
public class Ac_96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new Ac_96UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, Integer> map = new HashMap<>();

        public int numTrees(int n) {


            //如果只有0，或者1个节点，则可能的子树情况为1种
            if (n == 0 || n == 1) {
                return 1;
            }

            if (map.containsKey(n)) {
                return map.get(n);
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                //当用i这个节点当做根节点时

                //左边有多少种子树
                int leftNum = numTrees(i - 1);

                //右边有多少种子树
                int rightNum = numTrees(n - i);

                //乘起来就是当前节点的子树个数
                count += leftNum * rightNum;
            }

            map.put(n, count);

            return count;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}