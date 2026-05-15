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
    PriorityQueue<Pair> minHeap;
    public int[][] kClosest(int[][] points, int k) {
        minHeap = new PriorityQueue<>((a,b) -> Float.compare(b.dist, a.dist));
        for(int i=0;i< points.length;i++){
            minHeap.offer(new Pair(findDistance(points[i][0], points[i][1]), points[i][0], points[i][1]));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i=0;i< k;i++){
           ans[i][0] = minHeap.peek().x;
           ans[i][1] = minHeap.poll().y;
        }
        return ans;
    }

    public static float findDistance(int x1, int y1){
       return (float)Math.sqrt((Math.pow(x1, 2))+(Math.pow(y1, 2)));
    }
}
