package io.github.spafka.leetcode;

import java.util.stream.IntStream;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int val) {
        this.val = val;
    }
    public ListNode() {
    }
    public ListNode(int val,ListNode next) {

        this.val=val;
        this.next=next;
    }




    // 1-N的 SEQ
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


    public static ListNode reverseRecuiv(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode tail = reverseRecuiv(root.next);

        root.next.next = root;
        root.next = null;

        return tail;
    }


    public static ListNode reverseIter(ListNode root) {


        ListNode c = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = c;
            c = root;
            root = next;
        }

        return c;


    }

    @Override
    public String toString() {
        return String.format("[%s]", sb());
    }
    public String sb() {
        return next == null ? val + "" : val + "," + next.sb();
    }
}
