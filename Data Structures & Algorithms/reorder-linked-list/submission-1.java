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
    public void reorderList(ListNode head) {
        ListNode p;
        ListNode h = head;
        ListNode temp = head;
        Stack<ListNode> s = new Stack<>();
        while(temp != null){
            s.push(temp);
            temp = temp.next;
        }
        int n = s.size();
        while(s.size() > (n+1)/2){
            p = h;
            h = h.next;
            p.next = s.peek();
            s.peek().next = h;
            s.pop();
        }

        h.next = null;
        

    }
}
