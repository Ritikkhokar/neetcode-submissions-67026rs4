class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node lru;
    Node mru;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        lru = new Node(-1,-1);
        mru = new Node(-1,-1);
        lru.next = mru;
        mru.prev = lru;
    }

    public Node insert(Node node){
        // Node node = new Node(key, val);
        node.prev = mru.prev;
        node.next = mru;
        mru.prev.next = node;
        mru.prev = node;
        return node;
    }

    public static Node remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node removedNode = remove(map.get(key));
            insert(removedNode);
            return map.get(key).value;
        }else{
             return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
           Node node = map.get(key);
           node.value = value;
           remove(node);
           insert(node);
        }else{
            if(map.size() < capacity){
            Node node = new Node(key, value);
            insert(node);
            map.put(key, node);
            }else{
            Node removedNode = remove(lru.next);
            map.remove(removedNode.key);
            Node node = new Node(key, value);
            insert(node);
            map.put(key, node);
            }
        }
        
    }

}
