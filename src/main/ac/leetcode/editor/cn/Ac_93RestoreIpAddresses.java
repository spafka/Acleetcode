package leetcode.editor.cn;

//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros. 
//
// 
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
//.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
// 
//
// Given a string s containing only digits, return all possible valid IP 
//addresses that can be formed by inserting dots into s. You are not allowed to reorder 
//or remove any digits in s. You may return the valid IP addresses in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// 
//
// Example 2: 
//
// 
//Input: s = "0000"
//Output: ["0.0.0.0"]
// 
//
// Example 3: 
//
// 
//Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// s consists of digits only. 
// 
//
// Related Topics字符串 | 回溯 
//
// 👍 1167, 👎 0 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2023-03-12 14:34:17
 */
public class Ac_93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new Ac_93RestoreIpAddresses().new Solution();

        List<String> strings = solution.restoreIpAddresses("255255255255");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, new LinkedList<String>());
            return res;
        }

        void dfs(String s, int index, LinkedList<String> paths) {


            if (paths.size() > 4) {
                return;
            }
            if (index == s.length() && paths.size() == 4) {
                res.add(paths.stream().collect(Collectors.joining(".")));
            }

            if (index >= s.length()) {
                return;
            }

            char c = s.charAt(index);
            if (c == '0') {
                paths.add("0");

                dfs(s, index + 1, paths);
                paths.removeLast();
            } else if (c == '1' || c == '2') {
                for (int j = 1; j <= 3 && index + j <= s.length(); j++) {
                    String substring = s.substring(index, index + j);
                    int i1 = Integer.parseInt(substring);
                    if (i1 <= 255) {

                       // System.out.println("add << " + substring);
                        paths.add(substring);
                        dfs(s, index + j, paths);
                        paths.removeLast();
                    }
                }


            } else {
                for (int j = 1; j <= 2 && index + j <= s.length(); j++) {
                    String substring = s.substring(index, index + j);
                    int i1 = Integer.parseInt(substring);
                    if (i1 <= 100) {

                        paths.add(s.substring(index, index + j));
                       // System.out.println("add << " + substring);
                        dfs(s, index + j, paths);
                        paths.removeLast();

                    }
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}