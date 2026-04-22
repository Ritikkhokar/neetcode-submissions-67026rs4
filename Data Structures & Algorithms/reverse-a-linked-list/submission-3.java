/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode front = null;
        ListNode mid = null;
        ListNode end = head;

        while(end != null){
            mid = end;
            end = end.next;
            mid.next = front;
            front = mid;
        }
        return front;

    }
}
