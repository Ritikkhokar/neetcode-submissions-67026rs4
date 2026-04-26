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
        if(head == null)return null;
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node node = new Node(temp.val);
        map.put(temp, node);
        temp = temp.next;
        
        while(temp != null){
            Node nextNode = new Node(temp.val);
            map.put(temp,nextNode);
            node.next = nextNode;
            node = node.next;
            temp = temp.next;
        }
        Node prevListHead = head;
        while(prevListHead != null){
            Node newListHead = map.get(prevListHead);
            newListHead.random = map.get(prevListHead.random);
            prevListHead = prevListHead.next;
        }
        return map.get(head);
    }
}
