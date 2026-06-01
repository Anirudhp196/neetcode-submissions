class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                dfs(adjList, visit, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visit, int node) {
        visit[node] = true;
        for(int n: adjList.get(node)) {
            if(!visit[n]) {
                dfs(adjList, visit, n);
            }
        }
    }

    // General BFS
    // while queue is not empty, poll to get current node, search through neighbors, if it hasn't been visited yet,
    // add it to set and add it to queue
}
