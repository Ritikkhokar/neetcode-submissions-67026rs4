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
    ListNode curr;
    ListNode prev;
    ListNode future;
    public ListNode reverseKGroup(ListNode head, int k) {
        curr = null;
        prev = null;
        future = head;
        ListNode ans = null;
        int n = size(head);
        System.out.println("size = "+n);
        if(n<k)return head;
        for(int i=0;i<n/k;i++){
          ListNode previousFuture = future;
          ListNode previousCurrent = curr;
          reverse(k);
          if(i == 0){
            ans = curr;
            System.out.println(ans.val);
          }
          previousFuture.next = future;
          if(previousCurrent != null){
            previousCurrent.next = curr;
          }
          
          curr = previousFuture;
          prev = previousFuture;
        }
        return ans;
    }

    public  void reverse(int k){
        for(int i=0;i<k && future != null;i++){
            curr = future;
            future = future.next;
            curr.next = prev;
            prev = curr;
        }
    }

    public static int size(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
