class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productFromLeft = new int[nums.length];
        productFromLeft[0] = nums[0];
        int[] productFromRight = new int[nums.length];
        productFromRight[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            productFromLeft[i] = productFromLeft[i-1]*nums[i];
        }

        for(int i=nums.length-2;i>=0;i--){
            productFromRight[i] = productFromRight[i+1] * nums[i];
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
           if(i==0){
              ans[i] = productFromRight[i+1];
           }else if(i == nums.length-1){
              ans[i] = productFromLeft[i-1];
           } else{
             ans[i] = productFromRight[i+1] * productFromLeft[i-1];
           }
        }
        return ans;

    }
}  
