class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Kahn's Toposort Algorithm

        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] req: prerequisites) {
            inDegrees[req[0]]++;
            adjList.get(req[1]).add(req[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> ordering = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.poll();
            ordering.add(node);
            for(int n: adjList.get(node)) {
                inDegrees[n]--;
                if(inDegrees[n] == 0) {
                    q.offer(n);
                }
            }
        }
        if(ordering.size() == numCourses) {
            return true;
        }
        return false;
    }

}
