package leetcode.LinkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <p>
 * begin to intersect at node c1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Intersection_of_Two_Linked_Lists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = getListLen(headA), lenB = getListLen(headB);
            if (lenA == 0 || lenB == 0) return null;
            ListNode tmpA = headA, tmpB = headB;
            if (lenA > lenB) {
                int step = lenA - lenB;
                for (int i = 0; i < step; i++) {
                    tmpA = tmpA.next;
                }
            } else {
                int step = lenB - lenA;
                for (int i = 0; i < step; i++) {
                    tmpB = tmpB.next;
                }
            }
            while (tmpA != null && tmpB != null) {
                if (tmpA == tmpB)
                    return tmpA;
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
            return null;
        }

        public int getListLen(ListNode node) {
            if (node == null) return 0;
            int cnt = 0;
            while (node != null) {
                cnt++;
                node = node.next;
            }
            return cnt;
        }

        public ListNode getIntersectionNode_Better(ListNode headA, ListNode headB) {
            int lenA = getListLen(headA), lenB = getListLen(headB);
            ListNode tmpA = headA, tmpB = headB;
            while (lenA > lenB) {
                tmpA = tmpA.next;
                lenA--;
            }
            while (lenB > lenA) {
                tmpB = tmpB.next;
                lenB--;
            }
            while (tmpA != tmpB) {
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
            return tmpA;
        }
    }
}
