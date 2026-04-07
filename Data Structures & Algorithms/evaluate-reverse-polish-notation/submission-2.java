class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
               int b = st.pop();
               int a = st.pop();
               switch (tokens[i]) {
            case "+":
                sum= a + b;
                // st.push(sum);
                break;
            case "-":
                sum= a - b;
                // st.push
                break;
            case "*":
                sum= a * b;
                break;
            case "/":
                if (b == 0) throw new ArithmeticException("Divide by zero");
                sum= a / b;
                break;
               }
               st.push(sum);
            }else{
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.pop();
    }
}
