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
        ListNode past = null;
        ListNode present = null;
        ListNode future = head;

        while(future != null){
            present = future;
            future = present.next;
            present.next = past;
            past = present;
        }
        return present;
    }
}
