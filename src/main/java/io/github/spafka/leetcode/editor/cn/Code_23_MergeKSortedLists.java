package io.github.spafka.leetcode.editor.cn;
//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length won't exceed 10^4. 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1724 👎 0


import io.github.spafka.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2022-01-29 20:04:52
 * $@see{https://leetcode-cn.com/problems/merge-k-sorted-lists}
 */
public class Code_23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new Code_23_MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // base case
            if (lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> quesu = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    quesu.add(lists[i]);
                }
            }
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            while (!quesu.isEmpty()) {
                ListNode poll = quesu.poll();
                p.next = new ListNode(poll.val);
                if (poll.next != null) {
                    quesu.add(poll.next);
                }
                p = p.next;
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}