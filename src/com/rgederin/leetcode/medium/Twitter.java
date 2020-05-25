package com.rgederin.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Runtime: 34 ms, faster than 40.33% of Java online submissions for Design Twitter. Memory Usage:
 * 46.2 MB, less than 100.00% of Java online submissions for Design Twitter.
 *
 * Note - seems like also Max PQ could be used for more efficient solution
 */
class Twitter {

    private final Map<Integer, Set<Tweet>> tweets;
    private final Map<Integer, Set<Integer>> followers;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        tweets = new HashMap<>();
        followers = new LinkedHashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);

        if (tweets.containsKey(userId)) {
            tweets.getOrDefault(userId, new LinkedHashSet<>())
                    .add(tweet);
        } else {
            Set<Tweet> userTweets = new LinkedHashSet<>();
            userTweets.add(tweet);
            tweets.put(userId, userTweets);

            if (followers.containsKey(userId)) {
                followers.get(userId).add(userId);
            } else {
                Set<Integer> userFollowers = new LinkedHashSet<>();
                userFollowers.add(userId);
                followers.put(userId, userFollowers);
            }
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed
     * must be posted by users who the user followed or by the user herself. Tweets must be ordered
     * from most recent to least recent.
     *
     * @return
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> newsFeed = new ArrayList<>();

        if (followers.containsKey(userId)) {
            Set<Integer> followees = followers.get(userId);

            for (Integer followee : followees) {
                newsFeed.addAll(tweets.getOrDefault(followee, new LinkedHashSet<>()));
            }
        }
        newsFeed.sort(Comparator.comparingLong(Tweet::getTimestamp).reversed());

        return newsFeed.stream().limit(10).map(Tweet::getTweetId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.getOrDefault(followerId, new LinkedHashSet<>())
                    .add(followeeId);
        } else {
            Set<Integer> userFollowers = new LinkedHashSet<>();
            userFollowers.add(followeeId);
            followers.put(followerId, userFollowers);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (followers.containsKey(followerId)) {
            Set<Integer> followees = followers.get(followerId);
            followees.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.follow(2, 1);

        System.out.println(twitter.getNewsFeed(2));

        twitter.postTweet(2, 6);

        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
    }

    private class Tweet {
        private int tweetId;
        private long timestamp;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            timestamp = System.nanoTime();
        }

        public int getTweetId() {
            return tweetId;
        }

        public void setTweetId(int tweetId) {
            this.tweetId = tweetId;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tweet tweet = (Tweet) o;
            return tweetId == tweet.tweetId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(tweetId);
        }

        @Override
        public String toString() {
            return "Tweet{" +
                    "tweetId=" + tweetId +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}