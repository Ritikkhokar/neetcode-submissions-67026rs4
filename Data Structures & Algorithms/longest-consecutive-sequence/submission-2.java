class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max =0;
        
        for(int num : nums){
            map.put(num, 1);
        }

        for(int num : nums){
            if(map.containsKey(num-1)){
               map.put(num, getSequence(num-1, map) +1);
            }
            if(map.get(num) > max){
                max = map.get(num);
            }
        }
        return max;
    }

    public static int getSequence(int num, Map<Integer, Integer> map){
        if(!map.containsKey(num))return 0;

        if(map.get(num)>1){
            return map.get(num);
        }else{
            return getSequence(num-1, map) +1;
        }
    }
}
