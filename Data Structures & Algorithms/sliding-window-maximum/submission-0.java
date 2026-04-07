class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int[] answer = new int[nums.length - k + 1];
      Deque<Integer> deque =new ArrayDeque<>();

      for(int i=0;i<k;i++){
        while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
            deque.removeLast();
        }
        deque.addLast(i);
      }
      answer[0] = nums[deque.peekFirst()];
      for(int i=k;i<nums.length;i++){
         if(deque.peekFirst()<=i-k)deque.removeFirst(); 
         while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
            deque.removeLast();
        }
        deque.addLast(i);
        answer[i-k+1] = nums[deque.peekFirst()];
      } 
     return answer;
    }
}
