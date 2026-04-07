class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack();

        for(int i=temperatures.length-1;i>=0;i--){
            while(stack.size() != 0 && stack.peek()[0]<=temperatures[i]){
                stack.pop();
            }
            if(stack.size() == 0){
              res[i] = 0;
            }else{
              res[i] = stack.peek()[1]-i;
            }
            int[] val = new int[2];
            val[0] = temperatures[i];
            val[1] = i;
            stack.push(val);
            
        }
        return res;
    }
    
}
