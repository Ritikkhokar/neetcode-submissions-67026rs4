class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        makePermutations(nums, visited, new ArrayList<>());
        return ans;
    }

    public void makePermutations(int[] nums, boolean[] visited, List<Integer> list){

        // base case
        if(list.size() == nums.length){
            ans.add(new ArrayList(list));
            
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i] == false){
                list.add(nums[i]);
                visited[i] = true;
                makePermutations(nums, visited, list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
