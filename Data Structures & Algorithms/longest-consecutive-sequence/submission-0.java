class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(Integer num : set){
            int length = 1;
            while(set.contains(num + length)){
                length++;
            }
            if(length>max){
              max = length;
            }
        }
        return max;
    }
}
