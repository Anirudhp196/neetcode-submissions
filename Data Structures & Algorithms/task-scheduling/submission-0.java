class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c: tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int f: freq) {
            if(f > 0) {
                pq.add(f);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if(!pq.isEmpty()) {
                int newFreq = pq.poll() - 1;
                if(newFreq > 0) {
                    q.add(new int[] {newFreq, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
