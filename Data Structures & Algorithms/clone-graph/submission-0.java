/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        map = new HashMap<>();
        cloneGraph1(node);
        return map.get(node.val);
    }
    
    public void cloneGraph1(Node node) {
        if(!map.containsKey(node.val)){
           Node cloneNode = new Node(node.val);
           map.put(node.val, cloneNode);
           for(int i=0;i<node.neighbors.size();i++){
            cloneGraph1(node.neighbors.get(i));
            cloneNode.neighbors.add(map.get(node.neighbors.get(i).val));
           }
        }
    }

}