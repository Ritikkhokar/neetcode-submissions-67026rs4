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
        
       ListNode val = head;
       int a = remove(val,n);
       if(a == 0){
        return head.next;
       }
       return head;
    }
    public static int remove(ListNode head, int n){
        if(head == null){
            return n;
        }
        int  a = remove(head.next, n);
        if(a == 0){
            head.next = head.next.next;
        }
        return a-1;
    }
}
