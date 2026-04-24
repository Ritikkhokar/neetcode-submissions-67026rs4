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
        ListNode origHead = head;
        Stack<ListNode> st = new Stack<>();
        while(origHead != null){
            st.push(origHead);
            origHead = origHead.next;
        }
        int n = st.size();
        ListNode temp;
        while(st.size()> (n+1)/2){
            temp = head.next;
            head.next = st.peek();
            st.pop().next = temp;
            head = temp;
        }
        head.next = null;
    }
}
