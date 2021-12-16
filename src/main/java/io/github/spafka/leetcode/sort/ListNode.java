package io.github.spafka.leetcode.sort;


import org.junit.Test;

import java.util.stream.IntStream;

public class ListNode<T> {

    T t;
    ListNode<T> next;


    public ListNode(T t) {
        this.t = t;
    }

    public ListNode(T t, ListNode<T> next) {
        this.t = t;
        this.next = next;
    }

    public static ListNode listNode(int length) {
        assert length > 1;
        return IntStream.rangeClosed(1, length).mapToObj(x -> new ListNode(x))
                .reduce((a, b) -> {
                    ListNode h = a;
                    while (a.next != null) {
                        a = a.next;
                    }
                    a.next = b;
                    return h;
                }).get();

    }


    public static void preOrder(ListNode node) {

        if (node == null) return;
        System.out.println(node);
        preOrder(node.next);

    }

    public static void inOrder(ListNode node) {

        ListNode dummy = new ListNode<>(0, node);

        while (dummy.next != null) {
            System.out.println(dummy);
            dummy = dummy.next;
        }

    }

    public static void postOrder(ListNode node) {

        if (node == null) return;
        postOrder(node.next);
        System.out.println(node);

    }

    public static void main(String[] args) {

        ListNode listNode = listNode(5);
        preOrder(listNode);

        inOrder(listNode);

        postOrder(listNode);

    }

    @Override
    public String toString() {
        return "ListNode{" +
                "t=" + t +
                '}';
    }
}
