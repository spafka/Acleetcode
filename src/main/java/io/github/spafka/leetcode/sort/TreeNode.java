package io.github.spafka.leetcode.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeNode<T> {

    T t;

    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T t, TreeNode left, TreeNode right) {
        this.t = t;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T t) {
        this.t = t;
    }

    /**
     * 前序遍历
     */
    public String readPre() {
        StringBuilder result = new StringBuilder();
        result.append(t); //前序遍历
        if (left != null) {
            result.append(left.readPre());
        }
        if (right != null) {
            result.append(right.readPre());
        }
        return result.toString();
    }

    /**
     * 中序遍历
     */
    public String readMid() {
        StringBuilder result = new StringBuilder();
        if (left != null) {
            result.append(left.readMid());
        }
        result.append(t); //中序遍历
        if (right != null) {
            result.append(right.readMid());
        }
        return result.toString();
    }

    /**
     * 中序遍历
     */
    /**
     * 后序遍历
     */
    public String readEnd() {
        StringBuilder result = new StringBuilder();
        if (left != null) {
            result.append(left.readEnd());
        }
        if (right != null) {
            result.append(right.readEnd());
        }
        result.append(t); //后序遍历
        return result.toString();
    }

    /**
     * 层序遍历
     */
    public String readLevel() {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            result.append(curNode.t);
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }
        return result.toString();
    }

    /**
     * 根据前序和中序排序表获取树
     */
    private static TreeNode buildTreeByPreMid(char[] pre, int preBegin, int preEnd, char[] mid, int midBegin, int midEnd) {
        TreeNode root = new TreeNode(null);


        int midRootLoc = 0;
        for (int i = midBegin; i <= midEnd; i++) {
            if (mid[i] == pre[preBegin]) {
                midRootLoc = i;
                break;
            }
        }

        //递归得到左子树
        if (preBegin + (midRootLoc - midBegin) >= preBegin + 1 && (midRootLoc - 1) >= midBegin) {
            TreeNode left = buildTreeByPreMid(pre, preBegin + 1, preBegin + (midRootLoc - midBegin),
                    mid, midBegin, midRootLoc - 1);
            root.left = left;
        }

        //递归得到右子树
        if (preEnd >= (preEnd - (midEnd - midRootLoc) + 1) && (midEnd >= midRootLoc + 1)) {
            TreeNode right = buildTreeByPreMid(pre, preEnd - (midEnd - midRootLoc) + 1, preEnd,
                    mid, midRootLoc + 1, midEnd);
            root.right = right;
        }

        return root;
    }


    /**
     * 根据后序和中序遍历还原树
     */
    private static TreeNode buildTreeByMidEnd(char[] mid, int midBegin, int midEnd, char[] end, int endBegin, int endEnd) {
        TreeNode root = new TreeNode(end[endEnd] + "");

        int midRootLoc = 0;
        for (int i = midEnd; i >= midBegin; i--) {
            if (mid[i] == end[endEnd]) {
                midRootLoc = i;
                break;
            }
        }

        //还原左子树
        if (midRootLoc - 1 >= midBegin && (endBegin + (midRootLoc - midBegin) - 1 >= endBegin)) {
            TreeNode left = buildTreeByMidEnd(mid, midBegin, midRootLoc - 1, end, endBegin, endBegin + (midRootLoc - midBegin) - 1);
            root.left = left;
        }

        //还原右子树
        if (midEnd >= midRootLoc + 1 && (endEnd - 1 >= endEnd - (midEnd - midRootLoc))) {
            TreeNode right = buildTreeByMidEnd(mid, midRootLoc + 1, midEnd, end, endEnd - (midEnd - midRootLoc), endEnd - 1);
            root.right = right;
        }

        return root;
    }

    /**
     * 根据层序遍历和中序遍历得到结果
     *
     * @return
     */
    private static TreeNode buildTreeByMidLevel(char[] mid, char[] level, int midBegin, int midEnd) {
        TreeNode root = new TreeNode(level[0] + "");

        int midLoc = -1;
        for (int i = midBegin; i <= midEnd; i++) {
            if (mid[i] == level[0]) {
                midLoc = i;
                break;
            }
        }

        if (level.length >= 2) {
            if (isLeft(mid, level[0], level[1])) {
                TreeNode left = buildTreeByMidLevel(mid, getLevelStr(mid, midBegin, midLoc - 1, level), midBegin, midLoc - 1);
                root.left = left;
                if (level.length >= 3 && !isLeft(mid, level[0], level[2])) {
                    TreeNode right = buildTreeByMidLevel(mid, getLevelStr(mid, midLoc + 1, midEnd, level), midLoc + 1, midEnd);
                    root.right = right;
                }
            } else {
                TreeNode right = buildTreeByMidLevel(mid, getLevelStr(mid, midLoc + 1, midEnd, level), midLoc + 1, midEnd);
                root.right = right;
            }
        }
        return root;
    }

    /**
     * 如果c在target的左边，则返回true，否则返回false
     */
    private static boolean isLeft(char[] str, char target, char c) {
        boolean findC = false;
        for (char temp : str) {
            if (temp == c) {
                findC = true;
            } else if (temp == target) {
                return findC;
            }
        }
        return false;
    }

    /**
     * 将中序序列中midBegin与MidEnd的字符依次从level中提取出来，保持level中的字符顺序不变
     */
    private static char[] getLevelStr(char[] mid, int midBegin, int midEnd, char[] level) {
        char[] result = new char[midEnd - midBegin + 1];
        int curLoc = 0;
        for (int i = 0; i < level.length; i++) {
            if (contains(mid, level[i], midBegin, midEnd)) {
                result[curLoc++] = level[i];
            }
        }
        return result;
    }

    /**
     * 如果str字符串的begin和end位置之间（包括begin和end）含有字符target,则返回true。
     */
    private static boolean contains(char[] str, char target, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (str[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取默认的树
     *
     * @return
     */
    private static TreeNode buildDefaultTree() {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");
        TreeNode i = new TreeNode("I");
        a.left = b;
        a.right = c;
        b.left = d;
        d.left = g;
        d.right = h;
        c.left = e;
        c.right = f;
        e.right = i;
        return a;
    }

    public static void main(String[] args) {
        //ABDGHCEIF
        //GDHBAEICF
        //GHDBIEFCA
        String pre = "ABDGHCEIF"; //前序遍历
        String mid = "GDHBAEICF"; //中序遍历
        String end = "GHDBIEFCA"; //后序遍历
        String level = "ABCDEFGHI"; //层序遍历

        TreeNode defaultTree = buildDefaultTree();
        TreeNode preMidTree = buildTreeByPreMid(pre.toCharArray(), 0, pre.length() - 1, mid.toCharArray(),
                0, mid.length() - 1);

        TreeNode midEndTree = buildTreeByMidEnd(mid.toCharArray(), 0, mid.length() - 1, end.toCharArray(),
                0, end.length() - 1);

        TreeNode midLevelTree = buildTreeByMidLevel(mid.toCharArray(), level.toCharArray(), 0, mid.length() - 1);

        System.out.println(defaultTree.equals(preMidTree));
        System.out.println(defaultTree.equals(midEndTree));
        System.out.println(defaultTree.equals(midLevelTree));

        System.out.println(midLevelTree.readLevel());
        System.out.println(midLevelTree.readMid());
    }
}
