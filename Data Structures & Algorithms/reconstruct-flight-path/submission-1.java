class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for(int i=0;i<tickets.size();i++){
            if(graph.containsKey(tickets.get(i).get(0))){
               graph.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }else{
               graph.put(tickets.get(i).get(0), new ArrayList<>(List.of(tickets.get(i).get(1))));
            }
        }
        for (String airport : graph.keySet()) {
            Collections.sort(graph.get(airport));
        }

        LinkedList<String> result = new LinkedList<>();
        findRoute("JFK", graph, result);
        return result;
    }

    public void findRoute(String airport, Map<String, ArrayList<String>> graph, LinkedList<String> result) {
        ArrayList<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.remove(0);  // smallest unused ticket (list is sorted)
            findRoute(next, graph, result);
        }
        result.addFirst(airport);   // stuck here → prepend to answer
    }
}