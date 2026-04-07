class Pair{
    int userId;
    int tweetId;

    Pair(int userId, int tweetId){
        this.userId = userId;
        this.tweetId = tweetId;
    }
}
class Twitter {
    ArrayList<Pair> tweets;
    Map<Integer, ArrayList<Integer>> followingList;
    public Twitter() {
         tweets = new ArrayList();
         followingList = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Pair(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        int i=tweets.size()-1;
        int count = 0;
        while(i>=0 && count <10){
            Pair tweet = tweets.get(i);
            if(tweet.userId == userId ||
             (followingList.containsKey(userId) && followingList.get(userId).contains(tweet.userId))){
                feed.add(tweet.tweetId);
                count++;
             }
             i--;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followingList.containsKey(followerId)){
           ArrayList<Integer> followList = followingList.get(followerId);
           if(!followList.contains(followeeId)){
               followList.add(followeeId);
           }
        }else{
            followingList.put(followerId, new ArrayList<Integer>());
            followingList.get(followerId).add(followeeId);
        }
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followingList.containsKey(followerId)){
           ArrayList<Integer> followList = followingList.get(followerId);
           followList.remove(new Integer(followeeId));
        }
    }
}
