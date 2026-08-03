class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=edges.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[edges.length+1];
        int[] parent = new int[edges.length+1];
        Set<Integer> cycleEdgesSet = new HashSet<>();
        findCycle(graph, 1, -1, visited, cycleEdgesSet, parent);

        for(int i=edges.length-1;i>=0;i--){
            if(cycleEdgesSet.contains(edges[i][0]) &&  cycleEdgesSet.contains(edges[i][1]))       {
                return new int[]{edges[i][0], edges[i][1]};
            }
        }
        return new int[]{0,0};
    }

    public void findCycle(
        ArrayList<ArrayList<Integer>> graph, int src, int prevSrc, boolean[] visited, Set<Integer> cycleEdgesSet, int[] parent){
         if(cycleEdgesSet.size()>0)return;
         visited[src] = true;
         parent[src] = prevSrc;
         for(int i=0;i<graph.get(src).size();i++){
            if(graph.get(src).get(i) == prevSrc){
                continue;
            }
            else if(!visited[graph.get(src).get(i)]){
                findCycle(
                    graph, graph.get(src).get(i), src, visited, cycleEdgesSet, parent
                    );
            }else{
                // cycle found
                parent[graph.get(src).get(i)] = src;
                addCycleEdgesSet( src, cycleEdgesSet, parent);
            }
         }
        //  visited[src] = false;
        }

    public void addCycleEdgesSet(int src, Set<Integer> cycleEdgesSet, int[] parent){
        // visited[src] = false;
        // cycleEdgesSet.add(src);
        // System.out.println(Math.min(prevSrc,src) + ", " + Math.max(prevSrc,src));
        int startParent = src;
        while(parent[src] != startParent){
            cycleEdgesSet.add(src);
            src = parent[src];  
        }
        cycleEdgesSet.add(src);
        }
}
