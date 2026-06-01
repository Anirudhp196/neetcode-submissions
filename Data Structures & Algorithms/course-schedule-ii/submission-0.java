class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];

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
        
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for(int nei: adjList.get(node)) {
                inDegrees[nei]--;
                if(inDegrees[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if(res.size() != numCourses) {
            return new int[]{};
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
