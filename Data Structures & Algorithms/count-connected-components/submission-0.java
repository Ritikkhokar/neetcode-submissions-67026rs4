class Solution {
    public int countComponents(int n, int[][] edges) {
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
      }
      for(int i=0;i<edges.length;i++){
          graph.get(edges[i][0]).add(edges[i][1]);
          graph.get(edges[i][1]).add(edges[i][0]);
      }

      boolean[] visited = new boolean[n];
      int count = 0;
      for(int i=0;i<n;i++){
        if(!visited[i]){
            count++;
           markVisited(graph, i, visited);
        }
      }
      return count;

    }

    public void markVisited(
        ArrayList<ArrayList<Integer>> graph, int src,  boolean[] visited
        ){
        if(visited[src]){
            return;
        }
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            markVisited(graph, graph.get(src).get(i), visited);
        }
          
    }
}
