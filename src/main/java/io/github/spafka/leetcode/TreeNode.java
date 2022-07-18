package io.github.spafka.leetcode;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
        ListNode dummy=new ListNode(0);
         IntStream.rangeClosed(1, n).mapToObj(x -> new ListNode(x))
                .reduce(dummy,(a, b) -> {
                    a.next = b;
                    return b;
                });
        return dummy.next;

    }

    public static void inOrderIter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {  // 如果节点为空或栈为空  则遍历结束
            while (root != null) {  //如果根节点不为空
                stack.push(root);  // 将根节点压栈
                root = root.left;  //访问左子树
            }
            root = stack.pop(); // 存在节点为空  此时栈中从栈顶的元素一定为子树的最左边一个子节点
            System.out.println(root.val); // 将子节点存入列表中
            root = root.right;  //访问右节点
        }

    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6});

        view(root);
        inOrderIter(root);
    }


    public static TreeNode sortedArrayToBST(int[] nums) {

        return build(nums,0,nums.length-1);
    }



    public  static TreeNode build(int[] nums,int left,int right){
        if (left>right){
            return null;
        }
        int mid=(left+right)>>1;
        TreeNode root = new TreeNode();
        root.val=nums[mid];
        root.left=build(nums,left,mid-1);
        root.right=build(nums,mid+1,right);
        return root;
    }


    public static int  depth(TreeNode root){

        if (root==null){
            return 0;
        } else {
            return Math.min(depth(root.left),depth(root.right))+1;
        }
    }

    public static void view(TreeNode root){
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
            if (pop!= null) {
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
