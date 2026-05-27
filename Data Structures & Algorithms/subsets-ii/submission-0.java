class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        makeSubsets(nums, 0, new ArrayList<>());
        return ans;
    }

    public void makeSubsets(int[] nums, int idx, List<Integer> list){
      
    //   base case
    if(idx == nums.length){
        ans.add(new ArrayList(list));
        return;
    }

    //   left call
    list.add(nums[idx]);
    makeSubsets(nums, idx + 1, list);
    list.remove(list.size()-1);
    //   right call
    while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
        idx++;
    }
    makeSubsets(nums, idx + 1, list);

    }

}


