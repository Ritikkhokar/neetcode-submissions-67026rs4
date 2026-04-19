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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prevL1 = null;
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        ListNode head = list1.val <= list2.val ? list1 : list2;
        while(list1 != null && list2 != null){
            if(list1.val<= list2.val){
                prevL1 = list1;
                list1 = list1.next;
            }else{
                ListNode temp = list2;
                list2 = list2.next;
                if(prevL1 != null){
                    prevL1.next = temp;
                }
                prevL1 = temp;
                temp.next = list1;
            }
        }
        if(list1 == null){
           prevL1.next = list2;
        }
        return head;
    }
}