class Solution {
    static List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        makeSubsets(nums,0, new ArrayList<Integer>());
        return ans;
    }

    public static void makeSubsets(int[] nums, int idx,  List<Integer> list){
        // xbase condn
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        // no call
        makeSubsets(nums, idx+1, list);
        list.add(nums[idx]);
        // yes call
        makeSubsets(nums, idx+1, list);
        list.remove(list.size()-1);

    }
}
