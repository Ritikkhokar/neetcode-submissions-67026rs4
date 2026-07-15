class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[0]).add(p[1]);

        boolean[] inPath = new boolean[numCourses];  // cycle detection
        boolean[] done = new boolean[numCourses];    // your dp, revived
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!done[i] && !dfs(i, graph, inPath, done, ans)) return new int[0];
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean dfs(int src, List<List<Integer>> g, boolean[] inPath, boolean[] done, ArrayList<Integer> ans) {
        if (done[src]) return true;
        if (inPath[src]) return false;
        inPath[src] = true;
        for (int nxt : g.get(src)) {
            if (!dfs(nxt, g, inPath, done, ans)) return false;
        }
        inPath[src] = false;
        done[src] = true;
        ans.add(src);  // post-order: prereqs land in ans first
        return true;
    }
}
