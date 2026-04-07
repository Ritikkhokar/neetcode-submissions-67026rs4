class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i : nums){
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        

        List<Integer>[] frequencyList = new ArrayList[nums.length+1];

        for (int i = 0; i < frequencyList.length; i++) {
            frequencyList[i] = new ArrayList<>();
        }

        for(Integer i : frequencyMap.keySet()){
            frequencyList[frequencyMap.get(i)].add(i); 
        }

        
        
        List<Integer> ans = new ArrayList();
        for(int i=frequencyList.length-1;i>=0 && k>0;i--){
            ans.addAll(frequencyList[i]);
            k = k- frequencyList[i].size();
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}
