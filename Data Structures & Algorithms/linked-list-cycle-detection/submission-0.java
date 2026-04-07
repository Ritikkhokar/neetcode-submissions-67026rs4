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

public class Solution {
    public boolean hasCycle(ListNode head) {
         if(head == null || head.next == null)
            {
                return false;
            }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(slow != null)
        {
            if(fast == null || fast.next == null)
            {
                return false;
            }
            else if(slow == fast)
            {
                return true;
            }
            else
            {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }
}
