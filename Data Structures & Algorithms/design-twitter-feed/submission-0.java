class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweetMap;
    // userId -> List of tweets
    // each tweet = [timestamp, tweetId]

    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        // maxHeap element = [timestamp, tweetId, userId, tweetIndex]
        // sorted by most recent timestamp

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                // tweet = [timestamp, tweetId]

                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
                // push latest tweet from this followee:
                // [timestamp, tweetId, sourceUserId, indexInTweetList]
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] curr = maxHeap.poll();
            // curr = [timestamp, tweetId, userId, tweetIndex]

            res.add(curr[1]);

            int index = curr[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                // previous tweet from same user = [timestamp, tweetId]

                maxHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}