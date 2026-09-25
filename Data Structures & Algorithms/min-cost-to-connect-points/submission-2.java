class Pair{
   int destNode;
   int cost;

   Pair(int destNode, int cost){
    this.destNode = destNode;
    this.cost = cost;
   }

}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] inMST = new boolean[n];
        int totalCost = 0;
        int totalEdgesUsed = 0;
        pq.offer(new Pair(0,0));
        int[] minDist = new int[n];
        for(int i=0;i< n;i++){
            minDist[i] = Integer.MAX_VALUE;
        }

        while(totalEdgesUsed< n){
            Pair pair = pq.poll();
            int node = pair.destNode;
            int cost = pair.cost;
            if(inMST[node]) continue;
            
            inMST[node] = true;
            totalCost += cost;
            totalEdgesUsed++;

            for(int i=0;i<n;i++){
               if(!inMST[i]){
                int costToPoint = calculateManhattanDist(
                    points[i][0], points[i][1], points[node][0], points[node][1]
                );
                if(minDist[i]>costToPoint){
                    pq.offer(new Pair(i,costToPoint));
                    minDist[i] = costToPoint;
                }

               }
            }

        }

        return totalCost;

        
        
    }

    public int calculateManhattanDist(int x1, int y1, int x2, int y2){
        int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
        return dist;
    }
}
