/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        // ArrayList<Integer> random = new ArrayList<>();
        Node head3 = head;
        Node head2 = null;
        Node lastNode = null;
        while(head != null){
            Node listNode = new Node(head.val);
            if(head2 == null){
              head2 = listNode;
            }
            // random.add(head.random.val);
            map.put(head, listNode);
            if(lastNode != null){
               lastNode.next = listNode;
            }
            lastNode = listNode;
            head = head.next;            
        }

        while(head3 != null){
            map.get(head3).random = map.get(head3.random);
            head3 = head3.next;
        }
        return head2;
    }
}
