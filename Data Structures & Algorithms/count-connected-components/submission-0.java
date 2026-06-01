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

        Set<Integer> visited = new HashSet<>();
        int counter = 0;
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                bfs(i, visited, adjList);
                counter++;
            }
        }
        return counter;
    }

    private void bfs(int node, Set<Integer> visited, List<List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited.add(node);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int nei: adjList.get(curr)) {
                if(!visited.contains(nei)) {
                    visited.add(nei);
                    q.offer(nei);
                }
            }
        }
    }

    // General BFS
    // while queue is not empty, poll to get current node, search through neighbors, if it hasn't been visited yet,
    // add it to set and add it to queue
}
