class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }else{
                if(st.size()== 0)return false;
                if(st.peek() == map.get(ch)){
                    st.pop();
                }else{
                    return false;
                }
            }
            
        }
        if(st.size()>0)return false;
        return true;
    }
}
