class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) {
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if(!dfs(0,-1,visit,adjList)) {
            return false;
        }

        return visit.size() == n;
        
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adjList) {
        if(visit.contains(node)) {
            return false;
        }

        visit.add(node);
        for(int nei: adjList.get(node)) {
            if(nei == parent) {
                continue;
            }
            if(!dfs(nei, node, visit, adjList)) {
                return false;
            }
        }

        return true;
    }
}
