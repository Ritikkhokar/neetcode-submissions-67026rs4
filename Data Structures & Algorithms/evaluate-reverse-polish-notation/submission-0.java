class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || 
            tokens[i].equals("*") || tokens[i].equals("/")){
               int b = st.pop();
               int a = st.pop();
               switch(tokens[i]){
               case "+" -> st.push(a + b);
               case "-" -> st.push(a - b);
               case "*" -> st.push(a * b);
               case "/" -> st.push(a / b);
               default -> throw new IllegalArgumentException("Unsupported operator");
               }
               
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.get(st.size()-1);
    }
}
