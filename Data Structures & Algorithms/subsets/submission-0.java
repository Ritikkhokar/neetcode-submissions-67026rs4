class Solution {
    static List<List<Integer>> oddSubset;
    public List<List<Integer>> subsets(int[] nums) {
        oddSubset = new ArrayList();
        findOddsubsets(nums, 0,0, new ArrayList<Integer>());
        return oddSubset;
    }
    public static void findOddsubsets(int[] nums, int idx, int sum,
    ArrayList<Integer> elementsSoFar
    ){
       if(idx == nums.length){
            oddSubset.add(new ArrayList<>(elementsSoFar));
        return;
       }
    //    left call
    elementsSoFar.add(nums[idx]);
      findOddsubsets(nums, idx+1, sum + nums[idx], elementsSoFar);
      elementsSoFar.remove(elementsSoFar.size()-1);
    //   right call
      findOddsubsets(nums, idx+1, sum, elementsSoFar);

    }
}
