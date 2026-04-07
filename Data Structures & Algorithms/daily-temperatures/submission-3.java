class stObj{
    int num;
    int idx;

    stObj(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<stObj> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i =temperatures.length-1; i>=0;i--){
            while(st.size()>0 && st.peek().num <= temperatures[i]){
                st.pop();
              }
            if(st.size()==0){
             ans[i] = 0;
            }else{
                ans[i] = st.peek().idx - i;
            }
            st.push(new stObj(temperatures[i], i));

        }
        return ans;
        }
}

