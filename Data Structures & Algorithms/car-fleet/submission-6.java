class Pair{
    int position;
    int speed;

    public Pair(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
}
class Solution {
    
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] pairs = new Pair[speed.length];
        for(int i=0;i<speed.length;i++){
            pairs[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b.position, a.position));
        
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<pairs.length;i++){
            if(st.size()==0){
                st.push(new Pair(pairs[i].position, pairs[i].speed));
                continue;
            }
            Pair arrPair = pairs[i];
            float arrPairTime = (float)(target - arrPair.position)/arrPair.speed;
            Pair stPair = st.peek();
            float stackPairTime = (float)(target - stPair.position)/stPair.speed;
            if(arrPairTime>stackPairTime){
                st.push(new Pair(pairs[i].position, pairs[i].speed));
            } 
        }
        return st.size();
    }
}
