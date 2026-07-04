class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     List<List<Integer>> graph = new ArrayList<>();
     boolean[] visited = new boolean[numCourses];
     Boolean[] dp = new Boolean[numCourses];
     for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<>());
     }

     for(int i=0;i<prerequisites.length;i++){
        graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
     }

     for(int i=0;i<numCourses;i++){
        if(dp[i] == null){
            if(!checkValidity(i, graph, visited, dp)){
               return false;
            }
        }
     }
     return true;   
    }

    public boolean checkValidity(int src, List<List<Integer>> graph, boolean[] visited, Boolean[] dp){
        if(dp[src] != null){
            return dp[src];
        }
        visited[src] = true;
        
        for(int i=0;i<graph.get(src).size();i++){
            if(visited[graph.get(src).get(i)]){
                dp[src] = false;
                return false;
            }
            if(!checkValidity(graph.get(src).get(i), graph, visited, dp)){
                dp[src] = false;
               return false;
            }
        }
        visited[src] = false;
        dp[src] = true;
        return true;
    }

}
 