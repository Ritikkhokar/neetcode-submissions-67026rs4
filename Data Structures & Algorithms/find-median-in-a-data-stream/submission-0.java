class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        if(minHeap.size()<maxHeap.size()){
           minHeap.offer(num);
           if(maxHeap.size()>0 && minHeap.peek()< maxHeap.peek()){
            int minPeak = minHeap.poll();
            int maxPeak = maxHeap.poll();
            minHeap.offer(maxPeak);
            maxHeap.offer(minPeak);
           }
        }else{
           maxHeap.offer(num);
           if(minHeap.size()>0 && minHeap.peek()< maxHeap.peek()){
            int minPeak = minHeap.poll();
            int maxPeak = maxHeap.poll();
            minHeap.offer(maxPeak);
            maxHeap.offer(minPeak);
           }
        }
    }
    
    public double findMedian() {
        if((minHeap.size() + maxHeap.size())%2 == 0){
           return (double)(minHeap.peek() + maxHeap.peek())/2;
        }else{
           return maxHeap.peek();
        }
    }
}
