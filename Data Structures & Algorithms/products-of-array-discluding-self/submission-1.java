class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] pre = new int[nums.length];
       int[] suf = new int[nums.length];
       int[] res = new int[nums.length]; 
        
        if(nums.length == 1){
            return nums;
        }

        pre[0] = nums[0];
        suf[nums.length-1] = nums[nums.length-1];
       for(int i=1;i<nums.length;i++){
        pre[i] = pre[i-1]*nums[i];
       }
       for(int i=nums.length-2;i>=0;i--){
        suf[i] = suf[i+1]*nums[i];
       }
 
       for(int i=0;i<nums.length;i++){
        if(i ==0){
          res[i] = suf[i+1];
        }else if(i == nums.length-1){
          res[i] = pre[i-1];
        }else{
          res[i] = pre[i-1]*suf[i+1];
        }
        
       }

       return res;
       
    }
}  
