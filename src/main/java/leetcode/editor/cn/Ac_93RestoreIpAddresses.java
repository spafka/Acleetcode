
package leetcode.editor.cn;

//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics字符串 | 回溯 
//
// 👍 1387, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2024-02-27 00:00:04
 */
public class Ac_93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new Ac_93RestoreIpAddresses().new Solution();
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