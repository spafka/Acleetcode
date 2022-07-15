package leetcode;

import io.github.spafka.leetcode.ListNode;
import org.junit.Test;

public class ListNodes_Tests {


    @Test
    public void test_reverse() {

        ListNode listNode = ListNode.fromRange(5);
        ListNode reverse = ListNode.reverseRecuiv(listNode);
        System.out.println();
    }

    @Test
    public void test_reverse2() {
        ListNode listNode = ListNode.fromRange(5);
        ListNode reverse = ListNode.reverseIter(listNode);
        System.out.println();
    }
}
