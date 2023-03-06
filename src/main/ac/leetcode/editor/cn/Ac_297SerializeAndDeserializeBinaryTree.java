package leetcode.editor.cn;

//Serialization is the process of converting a data structure or object into a
//sequence of bits so that it can be stored in a file or memory buffer, or 
//transmitted across a network connection link to be reconstructed later in the same or 
//another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no 
//restriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this 
//string can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode 
//serializes a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树 
//
// 👍 1068, 👎 0 
//
//
//
//


import io.github.spafka.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 2023-03-05 21:59:00
 */
public class Ac_297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static class Codec {
        String SEP = ",";
        String NULL = "#";

        /* 主函数，将二叉树序列化为字符串 */
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        /* 辅助函数，将二叉树存入 StringBuilder */
        void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            /******前序遍历位置******/
            sb.append(root.val).append(SEP);
            /***********************/

            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        /* 主函数，将字符串反序列化为二叉树结构 */
        public TreeNode deserialize(String data) {
            // 将字符串转化成列表
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        /* 辅助函数，通过 nodes 列表构造二叉树 */
        TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;

            /******前序遍历位置******/
            // 列表最左侧就是根节点
            String first = nodes.removeFirst();
            if (first.equals(NULL)) return null;
            TreeNode root = new TreeNode(Integer.parseInt(first));
            /***********************/

            root.left = deserialize(nodes);
            root.right = deserialize(nodes);

            return root;
        }
    }
// 详细解析参见：
// https://labuladong.github.io/article/?qno=297


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}