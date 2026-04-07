class Solution {
    static List<List<Integer>> oddSubset;
    static int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        oddSubset = new ArrayList();
        this.target = target;
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
            oddSubset.add(new ArrayList<>(elementsSoFar));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            elementsSoFar.add(nums[i]);
            findOddsubsets(nums, i, sum + nums[i], elementsSoFar);
            elementsSoFar.remove(elementsSoFar.size()-1);
        }
        
    }


}

