class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> val = new ArrayList<>();
        int start = 0;
        Arrays.sort(candidates);
        combinationSum1(candidates,target,val,start,0);
        return ans;
    }
    public void combinationSum1(int[] candidates, int target, List<Integer> val,int start,int sum )
    {
        if(sum == target)
        {
         
            ans.add(new ArrayList<Integer>(val));
               // System.out.println(ans);
            return;
        }
        if(sum>target)
        {
            return;
        }
        
        for(int i=start;i<candidates.length;i++)
        {
            
            val.add(candidates[i]);
            
            combinationSum1(candidates,target,val,i+1,sum + candidates[i]);
            val.remove(val.size()-1);
            
            if(i != candidates.length-1 && candidates[i] == candidates[i+1])
            {
                int j=i+1;
                while(j<candidates.length && candidates[i] == candidates[j])
                {
                    j++;
                }
                i=j-1;
            }
        }
    }
}