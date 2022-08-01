package io.github.spafka.leetcode;


import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class TreeNode<N extends TreeNode> {
    public Integer val;
    public N left;
    public N right;


    public TreeNode() {
    }


    public TreeNode(int val, N left, N right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }


    public static ListNode fromRange(int n) {
        assert n > 1;
        ListNode dummy = new ListNode(0);
        IntStream.rangeClosed(1, n).mapToObj(x -> new ListNode(x))
                .reduce(dummy, (a, b) -> {
                    a.next = b;
                    return b;
                });
        return dummy.next;

    }
    // root l r
    public static List<Integer> preOrderIter(TreeNode root, List<Integer>... list) {

        list = list.length == 0 ? new List[]{new LinkedList()} : list;
        List res = list[0];
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {  // 如果节点为空或栈为空  则遍历结束
            while (root != null) {  //如果根节点不为空
                stack.push(root);
                res.add(root.val);
                // 将根节点压栈
                root = root.left;  //访问左子树
            }
            root = stack.pop(); // 存在节点为空  此时栈中从栈顶的元素一定为子树的最左边一个子节点
            root = root.right;  //访问右节点
        }

        return res;
    }

    //  l root r
    public static List<Integer> inOrderIter(TreeNode root, List<Integer>... list) {

        list = list.length == 0 ? new List[]{new LinkedList()} : list;
        List res = list[0];
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {  // 如果节点为空或栈为空  则遍历结束
            while (root != null) {  //如果根节点不为空
                stack.push(root);  // 将根节点压栈
                root = root.left;  //访问左子树
            }
            root = stack.pop(); // 存在节点为空  此时栈中从栈顶的元素一定为子树的最左边一个子节点
            res.add(root.val);
            root = root.right;  //访问右节点
        }
        return res;

    }
    // l r root
    public static List<Integer> postOrderIter(TreeNode root, List<Integer>... list) {

        list = list.length == 0 ? new List[]{new LinkedList()} : list;
        List res = list[0];
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {  // 如果节点为空或栈为空  则遍历结束
            while (root != null) {  //如果根节点不为空
                stack.push(root);
                res.add(root.val);
                root = root.right;  //访问左子树
            }
            root = stack.pop(); // 存在节点为空  此时栈中从栈顶的元素一定为子树的最左边一个子节点

            root = root.left;  //访问右节点
        }
        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13});

        view(root);
        List<Integer> integers = inOrderIter(root);
        List<Integer> integers1 = inOrderRecisv(root);

        Assert.assertArrayEquals(integers.toArray(), integers1.toArray());
        integers = preOrderIter(root);
        integers1 = preOrderRecisv(root);

        Assert.assertArrayEquals(integers.toArray(), integers1.toArray());

        integers = postOrderIter(root);
        integers1 = postOrderRecisv(root);

        Assert.assertArrayEquals(integers.toArray(), integers1.toArray());


    }

    private static List<Integer> preOrderRecisv(TreeNode root, List<Integer>... list) {

        if (list.length == 0) {
            list = new List[]{new LinkedList()};
        }

        if (root == null) {
            return list[0];
        }

        list[0].add(root.val);
        preOrderRecisv(root.left, list);
        preOrderRecisv(root.right, list);

        return list[0];
    }

    private static List<Integer> inOrderRecisv(TreeNode root, List<Integer>... list) {

        if (list.length == 0) {
            list = new List[]{new LinkedList()};
        }

        if (root == null) {
            return list[0];
        }
        inOrderRecisv(root.left, list);
        list[0].add(root.val);
        inOrderRecisv(root.right, list);

        return list[0];
    }

    private static List<Integer> postOrderRecisv(TreeNode root, List<Integer>... list) {

        if (list.length == 0) {
            list = new List[]{new LinkedList()};
        }

        if (root == null) {
            return list[0];
        }
        postOrderRecisv(root.left, list);
        postOrderRecisv(root.right, list);
        list[0].add(root.val);

        return list[0];
    }


    public static TreeNode sortedArrayToBST(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }


    public static TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode();
        root.val = nums[mid];
        root.left = build(nums, left, mid - 1);


        root.right = build(nums, mid + 1, right);
        return root;
    }


    public static int depth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            return Math.min(depth(root.left), depth(root.right)) + 1;
        }
    }

    public static void view(TreeNode root) {
        BTreePrinter.printNode(root);
    }

    public TreeNode search(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        } else if (root.val < val && root.right != null) {
            return search(root.right, val);

        } else if (root.val > val && root.left != null) {
            return search(root.left, val);
        } else {
            return null;
        }
    }

    public static String levelSer(TreeNode root) {

        TreeNode empty = new TreeNode();

        Queue<TreeNode> deq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        deq.add(root);
        while (!deq.isEmpty()) {
            TreeNode pop = deq.poll();
            if (pop != null) {
                sb.append(pop.val).append(",");
                deq.add(pop.left);
                deq.add(pop.right);
            } else {
                sb.append("#").append(",");
            }


        }
        return sb.toString();
    }

    public static TreeNode levelDer(String sb) {

        String[] split = sb.split(",");

        TreeNode<TreeNode> root = new TreeNode<>(Integer.parseInt(split[0]));
        ArrayDeque<TreeNode> dep = new ArrayDeque<>();
        dep.push(root);
        int index = 1;
        while (!dep.isEmpty() && index < split.length) {
            TreeNode pop = dep.pop();

            if (!split[index].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(split[index]));
                dep.addLast(left);
                pop.left = left;
            } else {
                pop.left = null;
            }

            index++;
            if (!split[index].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(split[index]));
                dep.addLast(right);
                pop.right = right;
            } else {
                pop.right = null;
            }
            index++;
        }

        return root;

    }


}
