class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for(int i=1;i<k;i++){
           while(deque.size()>0 && nums[i]>nums[deque.peekLast()]){
            deque.removeLast();
           }
           deque.addLast(i);
           
        }
        int[] ans = new int[nums.length - k +1];
        int j=0;
        for(int i=k;i<nums.length;i++){
            ans[j] = nums[deque.peekFirst()];
            if(deque.peekFirst()<=i-k)deque.removeFirst(); 
            while(deque.size()>0 && nums[i]>nums[deque.peekLast()]){
            deque.removeLast();
           }
           deque.addLast(i);
           j++;
        }
        ans[j] = nums[deque.peekFirst()];
        return ans;
    }
}
