class Solution {
    static List<List<Integer>> oddSubset;
    static int target;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        oddSubset = new ArrayList();
        this.target = target;
        Arrays.sort(nums);
        findOddsubsets(nums, 0,0, new ArrayList<Integer>());
        return oddSubset;
    }
    public static void findOddsubsets(int[] nums, int idx, int sum,
    ArrayList<Integer> elementsSoFar
    ){
        if( sum>target){
            return;
        }
        if(sum == target){
            if(!oddSubset.contains(elementsSoFar)){
               oddSubset.add(new ArrayList<>(elementsSoFar));
            }
            return;
        }
       if(idx == nums.length){
        return;
       }
       
       for(int i=idx;i<nums.length;i++){
        if(sum + nums[i] <= target){
            elementsSoFar.add(nums[i]);
            findOddsubsets(nums, i +1, sum + nums[i], elementsSoFar);
            elementsSoFar.remove(elementsSoFar.size()-1);
        }
       }
    }
}
