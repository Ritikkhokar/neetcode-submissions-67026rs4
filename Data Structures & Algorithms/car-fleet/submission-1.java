class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[][] timeToReachdestination = new float[position.length][2];
        for(int i=0;i<position.length;i++){
            timeToReachdestination[i][0] = target - position[i];
            timeToReachdestination[i][1] = (float)(target-position[i])/speed[i];
        }
        Arrays.sort(timeToReachdestination, (a, b) -> Float.compare(a[0], b[0]));
        Stack<float[]> st = new Stack<>();
        st.push(timeToReachdestination[0]);
        for(int i=1;i<timeToReachdestination.length;i++){
           if(timeToReachdestination[i][0] > st.peek()[0]
            && timeToReachdestination[i][1] > st.peek()[1]){
                st.push(timeToReachdestination[i]);
            }
        }
        return st.size(); 
    }
}
