package leetcode.editor.cn;

//Given two integers n and k, return all possible combinations of k numbers
//chosen from the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to 
//be the same combination.
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
//Explanation: There is 1 choose 1 = 1 total combination.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1308, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-12 12:30:36
 */
public class Ac_77Combinations {
    public static void main(String[] args) {
        Solution solution = new Ac_77Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {


            backtrack(1, n, k, new LinkedList<>());
            return res;
        }

        public void backtrack(int index, int n, int k, LinkedList<Integer> path) {

            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i <= n; i++) {


                path.addLast(i);
                backtrack(i + 1, n, k, path);
                path.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}