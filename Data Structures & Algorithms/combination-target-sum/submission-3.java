class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        makeCombinnations(nums,0,new ArrayList<Integer>(), 0, target);
        return ans;
    }

    public void makeCombinnations(int[] nums, int idx, List<Integer> list, int sum, int target){
        
        if(sum == target){
            ans.add(new ArrayList(list));
            return;
        }else if(sum>target){
            return;
        }

        for(int i = idx;i<nums.length;i++){
            sum += nums[i];
            list.add(nums[i]);
            makeCombinnations(nums, i, list, sum, target);
            sum -= nums[i];
            list.remove(list.size()-1);
        }
    }
}
