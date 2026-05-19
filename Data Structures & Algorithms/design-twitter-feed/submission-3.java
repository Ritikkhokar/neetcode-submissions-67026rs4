class Pair{
    int userId;
    int tweetId;

    Pair(int userId, int tweetId){
        this.userId = userId;
        this.tweetId = tweetId;
    }
}

class Twitter {
    List<Pair> tweets;
    Map<Integer, Set<Integer>> users;

    public Twitter() {
        tweets = new ArrayList<>();
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Pair(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds  = new ArrayList<>();
        for(int i = tweets.size()-1; i>=0; i--){
            if(tweets.get(i).userId == userId || 
              (users.containsKey(userId) && users.get(userId).contains(tweets.get(i).userId))){
              feeds.add(tweets.get(i).tweetId);
            }
            if(feeds.size() == 10)break;
        }
        return feeds;

    }
    
    public void follow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
           users.get(followerId).add(followeeId);
        }else{
           users.put(followerId, new HashSet<>());
           users.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).remove(followeeId);
    }
}
