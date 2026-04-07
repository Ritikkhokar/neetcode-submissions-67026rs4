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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode c = null;
        ListNode head = null;
        if(a== null){
            return b;
        }else if(b == null){
            return a;
        }
        if(a.val<=b.val){
            c = a;
            a= a.next;
        }else{
            c=b;
            b= b.next;
        }
        head = c;
        while(a != null || b != null){
           if(a != null && b != null){
            if(a.val<= b.val){
              c.next = a;
              c=c.next;
              a=a.next;
            }else{
              c.next = b;
              c=c.next;
              b = b.next;
            }
           }else if(a!= null){
            c.next = a;
            break;
           }else if(b != null){
            c.next = b;
            break;
           }
        }
        return head;


    }
}