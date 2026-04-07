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
        Stack<ListNode> stack = new Stack<>();
        ListNode val = head;
        while(val != null){
            stack.push(val);
            val = val.next;
        }
        while(stack.peek().next != head.next){
          stack.peek().next = head.next;
          head.next = stack.peek();
          head = stack.peek().next;
          stack.pop();
        }
        head.next = null;
    }
    
}
