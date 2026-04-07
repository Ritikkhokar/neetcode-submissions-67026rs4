class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]max = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            // check no discard element in queue
            if(deque.size()>0 && deque.peekFirst()<=i-k){
                deque.removeFirst();
            }
            // add element in queue
            while(deque.size()>0 && nums[deque.peekLast()]<=nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            // store max of window
            if(i>=k-1){
                max[i-k+1] = nums[deque.peekFirst()];
            }
            
        }
        return max;
    }
}
