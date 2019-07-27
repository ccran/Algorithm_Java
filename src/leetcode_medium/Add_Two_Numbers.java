package leetcode_medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Add_Two_Numbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null, p = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + carry;
            if (res == null) {
                res = new ListNode(tmp % 10);
                p = res;
            } else {
                p.next = new ListNode(tmp % 10);
                p = p.next;
            }
            carry = tmp / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode tl = l1 == null ? l2 : l1;
        while (tl != null) {
            int tmp = tl.val + carry;
            p.next = new ListNode(tmp % 10);
            p = p.next;
            carry = tmp / 10;
            tl = tl.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return res;
    }

}
