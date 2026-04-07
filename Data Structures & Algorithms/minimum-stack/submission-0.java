class MinStack {
      ArrayList<int[]> st;
    public MinStack() {
        st = new ArrayList();
    }
    
    public void push(int val) {
        if(st.size()>0){
            st.add(new int[]{val,Math.min(val, st.get(st.size()-1)[1])});
        }else{
            st.add(new int[]{val,val});
        }
    }
    
    public void pop() {
        if(st.size()>0){
       st.remove(st.size()-1); 
        }
    }
    
    public int top() {
        if(st.size()>0){
            return st.get(st.size()-1)[0];
        }else{
            return -1;
        }
    }
    
    public int getMin() {
        if(st.size()>0){
            return st.get(st.size()-1)[1];
        }else{
            return -1;
        }
    }
}
