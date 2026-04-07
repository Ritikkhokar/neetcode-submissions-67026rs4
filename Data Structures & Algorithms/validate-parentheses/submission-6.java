class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '['){
               st.push(s.charAt(i));
            }else{
               if(st.size()>0 && st.peek() == map.get(s.charAt(i))){
                st.pop();
               }else {
                return false;
               }
            }
        
        }
        if(st.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
