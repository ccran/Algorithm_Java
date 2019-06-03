package leetcode.LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class Palindrome_Linked_List {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    //双链 + 链表反转
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head==null) return true;
            ListNode pre = head, aft = head;
            while (aft != null && aft.next != null) {
                pre = pre.next;
                aft = aft.next.next;
            }
            pre = reverse(pre);
            while(head!=null && pre!=null){
                if(head.val!=pre.val)
                    return false;
                head = head.next;
                pre = pre.next;
            }
            return true;
        }

        public ListNode reverse(ListNode pre) {
            ListNode after = pre.next;
            pre.next = null;
            while (after != null) {
                ListNode tmp = after.next;
                after.next = pre;
                pre = after;
                after = tmp;
            }
            return pre;
        }
    }
}
