public class Pair{
    float dist;
    int x;
    int y;

    Pair(float dist, int x, int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Float.compare(b.dist, a.dist));
    public int[][] kClosest(int[][] points, int k) {
        for(int i=0;i<points.length;i++){
            float dist = findDistance(points[i][0], points[i][1]);
            minHeap.offer(new Pair(dist, points[i][0], points[i][1]));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            Pair p = minHeap.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }

    public static float findDistance(int x1, int y1){
       return (float)Math.sqrt((Math.pow(x1, 2))+(Math.pow(y1, 2)));
    }
}
