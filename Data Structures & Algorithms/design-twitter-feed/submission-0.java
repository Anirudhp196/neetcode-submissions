class Twitter {

    // Map of userID -> [tweetID]
    Map<Integer, List<int[]>> tweetMap;
    // Map of userID -> Set of followers
    Map<Integer, Set<Integer>> followerMap;
    // int time
    int time;

    public Twitter() {
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if(followerMap.containsKey(userId)) {
            users.addAll(followerMap.get(userId));
        }

        for (int uid : users) {
            if (!tweetMap.containsKey(uid)) continue;
            List<int[]> tweets = tweetMap.get(uid);
            int lastIdx = tweets.size() - 1;
            // [time, tweetId, userId, index]
            heap.offer(new int[]{tweets.get(lastIdx)[0], tweets.get(lastIdx)[1], uid, lastIdx});
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty() && result.size() < 10) {
            int[] top = heap.poll();
            result.add(top[1]);

            int nextIdx = top[3] - 1; // move backwards (older tweets)
            if (nextIdx >= 0) {
                List<int[]> tweets = tweetMap.get(top[2]);
                heap.offer(new int[]{tweets.get(nextIdx)[0], tweets.get(nextIdx)[1], top[2], nextIdx});
            }
        }
        return result;

    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId)) {
            followerMap.get(followerId).remove(followeeId);
        }
    }
}
