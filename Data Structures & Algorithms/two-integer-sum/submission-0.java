class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> differenceMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(differenceMap.containsKey(target-nums[i])){
                return new int[]{differenceMap.get(target-nums[i]),i};
            }else{
                differenceMap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
