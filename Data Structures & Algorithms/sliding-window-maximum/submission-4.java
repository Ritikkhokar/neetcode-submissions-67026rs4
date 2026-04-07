class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList();
        for(int i=0;i<k && i< nums.length;i++){
            while(deque.size()>0 && nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        ans.add(nums[deque.peekFirst()]);
        for(int i=k;i<nums.length;i++){
           if(deque.peekFirst()<=i-k)deque.removeFirst(); 
            while(deque.size()>0 && nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            ans.add(nums[deque.peekFirst()]);
        }
         return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}
