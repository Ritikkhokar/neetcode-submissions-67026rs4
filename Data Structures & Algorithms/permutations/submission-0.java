class Solution {
    static List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList();
        boolean[] visit = new boolean[nums.length];
        findPermute(nums, visit, new ArrayList<Integer>(), nums.length);
        return ans;
    }

    public static void findPermute(int[] nums, boolean[] visit, 
    ArrayList<Integer> elementsSoFar, int n){
        if(n == 0){
            ans.add(new ArrayList<>(elementsSoFar));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visit[i] == false){
                elementsSoFar.add(nums[i]);
                visit[i] = true;
                findPermute(nums, visit, elementsSoFar,n-1);
                visit[i] = false;
                elementsSoFar.remove(elementsSoFar.size()-1);
            }
        }
    }
}
