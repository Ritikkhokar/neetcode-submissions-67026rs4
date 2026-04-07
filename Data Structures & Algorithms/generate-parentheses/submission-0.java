class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n,1,0,"(", ans);
        return ans;
    }

    public static void backtrack(int n, int lc, int rc, String str, List<String> ans){
      if(str.length()==n*2){
        ans.add(str);
        return;
      }

      if(lc<n){
        backtrack(n, lc + 1, rc, str + "(", ans);
      }

      if(rc<lc){
        backtrack(n, lc, rc + 1, str + ")", ans);
      }

    }
}
