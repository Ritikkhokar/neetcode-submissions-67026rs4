class Pair {
    int height;
    int idx;

    public Pair(int height, int idx){
        this.height = height;
        this.idx = idx;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int []leftArr = new int[heights.length];
        int []rightArr = new int[heights.length];
        rightArr[rightArr.length-1] = rightArr.length-1;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(heights[0], 0));
        for(int i=1;i<heights.length;i++){
            while(st.size()>0 && heights[i] <= st.peek().height ){
                st.pop();
            }
            if(st.size()==0){
               leftArr[i] = 0;
            }else{
                leftArr[i] = st.peek().idx +1;
            }
            st.push(new Pair(heights[i], i));
        }

        for(int i=0;i< leftArr.length;i++){
            System.out.print(leftArr[i]);
        }
        System.out.println();

        
        st = new Stack<>();
        st.push(new Pair(heights[heights.length-1], heights.length-1));
        for(int i=heights.length-2;i>=0;i--){
            while(st.size()>0 && heights[i] <= st.peek().height){
                st.pop();
            }
            if(st.size()==0){
               rightArr[i] = heights.length-1;
            }else{
               rightArr[i] = st.peek().idx -1;
            }
            st.push(new Pair(heights[i], i));
        }

        for(int i=0;i< rightArr.length;i++){
            System.out.print(rightArr[i]);
        }
        int max = 0;
        for(int i=0;i< heights.length;i++){
            max = Math.max((Math.abs(leftArr[i] - rightArr[i]) + 1)* heights[i], max);
        }
        return max;
    }
    

}