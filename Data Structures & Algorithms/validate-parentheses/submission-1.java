class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closedFor = new HashMap<>();
        closedFor.put(')', '(');
        closedFor.put('}', '{');
        closedFor.put(']', '[');
        for(int i=0;i<s.length();i++){
           if(s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')'){
            //  while(stack.size()>0 && stack.peek() != closedFor.get(s.charAt(i))){
            //     stack.pop();
            //  }

             if(stack.size()>0 && stack.peek() == closedFor.get(s.charAt(i))){
                stack.pop();
             }else{
                return false;
             }

           }else{
            stack.push(s.charAt(i));
           }
        }
        if(stack.size()>0){
            return false;
        }else{
            return true;
        }
        
    }
}
