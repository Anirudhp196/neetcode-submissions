class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,-1});
        set.add(0);

        while(!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0]; int parent = pair[1];
            for(int nei: adjList.get(node)) {
                if(nei == parent) {
                    continue;
                }
                if(set.contains(nei)) {
                    return false;
                }
                set.add(nei);
                q.offer(new int[]{nei, node});
            }
        }

        return set.size() == n;


    }
}
