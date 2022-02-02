package io.github.spafka.leetcode;


import java.util.stream.IntStream;

public class TreeNode<N extends TreeNode> {
    public int val;
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
        ListNode dummy=new ListNode();
         IntStream.rangeClosed(1, n).mapToObj(x -> new ListNode(x))
                .reduce(dummy,(a, b) -> {
                    a.next = b;
                    return b;
                });
         return dummy.next;

    }


}
