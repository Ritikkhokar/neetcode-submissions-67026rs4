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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while(l1 != null || l2 != null){
                ans.next = new ListNode();
                ans = ans.next;
            
           int l1Digit = l1 != null ? l1.val : 0;
           int l2Digit = l2 != null ? l2.val : 0;
           
        //    if(l1Digit == 0 && l2Digit == 0)continue;
           ans.val = (l1Digit + l2Digit + carry)%10;
           carry = (l1Digit + l2Digit + carry)/10;
           l1 = l1 != null ? l1.next : null;
           l2 = l2 != null ? l2.next : null;
           
        }
        if(carry != 0){
            ans.next = new ListNode(carry);
        }
        return temp.next;
    }
}
