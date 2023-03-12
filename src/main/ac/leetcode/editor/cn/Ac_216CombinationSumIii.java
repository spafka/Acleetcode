package leetcode.editor.cn;

//Find all valid combinations of k numbers that sum up to n such that the
//following conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain 
//the same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 636, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2023-03-12 17:42:05
 */
public class Ac_216CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new Ac_216CombinationSumIii().new Solution();
        solution.combinationSum3(3, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {

            dfs(1, 0, 0, k, n);
            return res;
        }

        public void dfs(int index, int currentSum, int usedNumber, int k, int n) {
            if (usedNumber > k || currentSum > n) {
                return;
            }
            if (currentSum == n && k == usedNumber) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i <= 9; i++) {

                path.add(i);
                dfs(i+1, currentSum + i, usedNumber + 1, k, n);
                path.removeLast();

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}