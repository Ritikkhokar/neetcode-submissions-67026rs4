class Solution {
    public boolean hasDuplicate(int[] nums) {
    // Map<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> hashSet = new HashSet<>();
    for(int i=0;i<nums.length;i++){
        if(hashSet.contains(nums[i])){
           return true;
        }else{
            hashSet.add(nums[i]);
        }
    }
    return false;

    }
}
