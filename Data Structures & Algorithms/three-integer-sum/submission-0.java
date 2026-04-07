class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<nums.length;i++){
            int fixedVal = nums[i];
            if(fixedVal>0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
            if(nums[l] + nums[r] + fixedVal < 0){
                l++;
                while(l<r && nums[l] == nums[l-1]){
                    l++;
                }
            }else if(nums[l] + nums[r] + fixedVal > 0){
                r--;
                while(l<r && nums[r] == nums[r+1]){
                    r--;
                }
            }else{
                ArrayList<Integer> li = new ArrayList<Integer>(); 
                li.add(fixedVal);
                li.add(nums[l]);
                li.add(nums[r]);
                ans.add(li);
                l++;
                r--;
                while(l<r && nums[l] == nums[l-1]){
                    l++;
                }
            }
            }
        }
        return ans;
    }

}
