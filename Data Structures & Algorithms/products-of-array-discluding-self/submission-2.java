class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];
        leftArr[0] = nums[0];
        rightArr[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            leftArr[i] = nums[i]* leftArr[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            rightArr[i] = nums[i]* rightArr[i+1];
        }

        // for(int i=0;i<nums.length;i++){
        //     System.out.print(leftArr[i] + ",");
        // }
        // System.out.println();
        // for(int i=0;i<nums.length;i++){
        //     System.out.print(rightArr[i] + ",");
        // }
        // System.out.println();
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                ans[i] = rightArr[i+1];
            }else if(i == nums.length-1){
                ans[i] = leftArr[i-1];
            }else{
                ans[i] = leftArr[i-1] * rightArr[i+1];
            }
        }

        return ans;
    }
}  
