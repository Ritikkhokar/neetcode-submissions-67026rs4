class LRUCache {
    Map<Integer, Integer> map = null;
    Stack<Integer> stack = null;
    int cap=0;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        stack = new Stack<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
          stack.push(key);
          return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            stack.push(key);
        }else if(map.size()>=cap){
           Set<Integer> set = new HashSet<>();
           Stack<Integer> tempStack = new Stack<>();
           while(stack.size()>0){
             int element = stack.pop();
             set.add(element);
             if(set.size() == cap){
                map.remove(element);
                map.put(key,value);
                while(tempStack.size()>0){
                    stack.push(tempStack.pop());
                }
                stack.push(key);
                return;
             }
             tempStack.push(element);
           }
        }else{
            map.put(key,value);
            stack.push(key);
        }
    }
}
