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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       int ans = remove(head,n);
       if(ans == 0){
        return head.next;
       }
        return head;
       
    }
    public static int remove(ListNode head, int n){
        if(head == null){
            return n;
        }
        n = remove(head.next, n);
        if(n == 0){
            head.next = head.next.next;
        }
        return n-1;
    }
}
