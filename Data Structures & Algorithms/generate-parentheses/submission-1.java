class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        generate(n, "", 0,0,ans);
        return ans;
    }

    public static void generate(int n, String str, int open, int close, List<String> ans){
        
        if(str.length() >= n*2){
            ans.add(str);
            return;
        }


        // open call
        if(open<n){
           generate(n, str + "(", open +1, close, ans);
        }
        
        // close call
        if(close<open){
           generate(n, str + ")", open, close + 1, ans);
        }
    }
}
