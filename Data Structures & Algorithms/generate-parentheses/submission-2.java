class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        generate(open, close,n,"");
        return ans;
    }

    public void generate(int open, int close, int n, String str){
        
        if(str.length()== n*2){
            ans.add(str);
            return;
        }
        // open call
        if(open<n){
            generate(open + 1, close,n,str + "(");
        }

        // close call
        if(close<open){
            generate(open, close +1,n,str + ")");
        }
    }
}
