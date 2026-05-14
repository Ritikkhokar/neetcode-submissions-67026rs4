class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            maxHeap.offer(i);
        }
        while(maxHeap.size() > 1){
          int a = maxHeap.poll();
          int b = maxHeap.poll();
          int diff = Math.abs(a-b);
          if(diff>0){
            maxHeap.offer(diff);
          }
        }
        return maxHeap.size()> 0 ? maxHeap.peek() : 0;
    }
}
