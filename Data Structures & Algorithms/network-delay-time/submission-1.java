class Pair{
   int destNode;
   int time;

   Pair(int destNode, int time){
    this.destNode = destNode;
    this.time = time;
   }

}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(n == 1) return 0;
        int[] minDist = new int[n+1];
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            minDist[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<times.length;i++){
            graph.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.time - b.time);
        q.add(new Pair(k, 0));
        minDist[k] = 0;
        int ans = Integer.MIN_VALUE;

        while(q.size() > 0){
            Pair curr = q.remove();
            int node = curr.destNode;
            int dist = curr.time;

            if(dist > minDist[node]) continue;   // stale snapshot, skip

            for(int i=0;i<graph.get(node).size();i++){
                int next = graph.get(node).get(i).destNode;
                int newDist = dist + graph.get(node).get(i).time;
                if(newDist < minDist[next]){
                    minDist[next] = newDist;
                    q.add(new Pair(next, newDist));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(minDist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(minDist[i], ans);
        }

        return ans;
    }
}