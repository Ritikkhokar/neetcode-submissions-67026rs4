class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            int maxKey = -2000;
            int maxValue = -2000;
            for(Integer key :map.keySet()){
                if(map.get(key)>maxValue){
                   maxKey = key;
                   maxValue = map.get(key);
                }
            }
            arr[i] = maxKey;
            map.put(maxKey,-1);
        }
        return arr;
    }
}
