class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxlen = 0;
        for(int num : nums){
            int len = 1;
            while(set.contains(num+1)){
                len++;
                num = num +1;
            }
            maxlen = Math.max(len, maxlen); 
        }
        return maxlen;
    }
}
