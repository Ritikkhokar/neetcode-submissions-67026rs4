class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k = 0;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int i : nums){
            minHeap.add(i);
        }
        while(minHeap.size()>k){
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
