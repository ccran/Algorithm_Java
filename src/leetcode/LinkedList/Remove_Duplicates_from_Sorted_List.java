package leetcode.LinkedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class Remove_Duplicates_from_Sorted_List {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode tmp = head;
            while (tmp != null && tmp.next != null) {
                if (tmp.val == tmp.next.val) {
                    tmp.next = tmp.next.next;
                } else {
                    tmp = tmp.next;
                }
            }
            return head;
        }
    }
}
