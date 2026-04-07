class Solution {
    public int findMin(int[] nums) {
        int l= 0;
        int r = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(l<=r){
            int mid = (l+r)/2;
            ans = Math.min(ans, nums[mid]);
            if(nums[mid]<nums[r]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
