package io.github.spafka.leetcode;

import java.util.stream.IntStream;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
