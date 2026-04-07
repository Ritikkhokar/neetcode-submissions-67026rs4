class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[][] timeToReach = new float[position.length][2];
        for(int i=0;i<position.length;i++){
            timeToReach[i][0] = (float)position[i];
            timeToReach[i][1] = (float)(target - position[i])/speed[i];
        }
        Arrays.sort(timeToReach, (a,b) -> Float.compare(b[0], a[0]));
        Stack<float[]> st = new Stack<>();
        for(int i=0;i<timeToReach.length;i++){
            if(st.size()> 0 && timeToReach[i][1] <= st.peek()[1]){
                continue;
            }else{
                st.push(timeToReach[i]);
            }
        }
        return st.size();
    }
}
