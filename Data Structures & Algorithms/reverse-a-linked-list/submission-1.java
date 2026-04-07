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
        if(head == null || head.next == null)return head;
        ListNode prev = null;
        ListNode pre = head;
        ListNode fut = head.next;
        while(fut != null){
            pre.next = prev;
            prev = pre;
            pre = fut;
            fut = fut.next;
        }
        pre.next = prev;
        prev = pre;
        return pre;
    }
}
