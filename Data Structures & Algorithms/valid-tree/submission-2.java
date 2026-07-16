class Solution {
    public boolean validTree(int n, int[][] edges) {
     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
     for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
     }
     for(int i=0;i<edges.length;i++){
        if(edges[i][0] == edges[i][1])return false;
        graph.get(edges[i][0]).add(edges[i][1]);
        graph.get(edges[i][1]).add(edges[i][0]);
     }

     boolean[] visited = new boolean[n];
    //   recur calll

     if(!checkValidity(0, visited, graph, 0)){
        return false;
     }
     
     for(int i=0;i<n;i++){
        if(!visited[i]){
            return false;
        }
     }
     return true;
    
    }

    public boolean checkValidity(
        int src, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int preViousSrc
    ){
        visited[src] = true;
        for(int i=0;i<graph.get(src).size();i++){
            if(graph.get(src).get(i) != preViousSrc){
               if(visited[graph.get(src).get(i)])return false;
               if(!checkValidity(graph.get(src).get(i), visited, graph, src)){
                return false;
               }
            }
        }
        return true;
    }
}
