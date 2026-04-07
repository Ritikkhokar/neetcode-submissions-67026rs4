class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int a = 0;
        int b = 0;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
              switch(tokens[i]){
                case "+": 
                 a = st.pop();
                 b = st.pop();
                st.push(b+a);
                break;
                case "-": 
                 a = st.pop();
                 b = st.pop();
                st.push(b-a);
                break;
                case "*": 
                 a = st.pop();
                 b = st.pop();
                st.push(b*a);
                break;
                case "/": 
                 a = st.pop();
                 b = st.pop();
                st.push(b/a);
                break;
              }
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
