package leetcode.LinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class Remove_Linked_List_Elements {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null) {
                if (head.val == val) {
                    head = head.next;
                } else {
                    break;
                }
            }
            if (head == null) return head;
            ListNode pre = head, aft = head.next;
            while (aft != null) {
                if (aft.val == val) {
                    pre.next = aft.next;
                }
                else{
                    pre = pre.next;
                }
                aft = aft.next;
            }
            return head;
        }
    }
}
