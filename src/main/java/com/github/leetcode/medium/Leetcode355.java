package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 14:02
 * @Description: Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Leetcode355 {
    class Twitter {
        int number = 0;
        Map<Integer, Set<Integer>> users;  // user --> user follow list
        Map<Integer, List<Tweet>> tweets; // user -->  users' tweets

        public class Tweet {
            int userId;
            int tweetId;
            int num;

            public Tweet(int userId, int tweetId) {
                this.userId = userId;
                this.tweetId = tweetId;
                this.num = number++;
            }
        }

        public Twitter() {
            users = new HashMap<>();
            tweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!tweets.containsKey(userId)) tweets.put(userId, new LinkedList<Tweet>());
            tweets.get(userId).add(new Tweet(userId, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((t1, t2) -> t1.num - t2.num);
            Set<Integer> follow = users.get(userId) == null ? new HashSet<Integer>() : users.get(userId);
            follow.add(userId);
            for (int uid : follow) {
                List<Tweet> temp = tweets.get(uid);
                if (temp != null) {
                    for (Tweet t : temp) {
                        if (pq.size() < 10) pq.add(t);
                        else {
                            if (t.num > pq.peek().num) {
                                pq.poll();
                                pq.add(t);
                            }
                        }
                    }
                }
            }
            int count = 0;
            LinkedList<Integer> list = new LinkedList<Integer>();
            while (!pq.isEmpty() && count++ < 10) {
                list.addFirst(pq.poll().tweetId);
            }
            return list;
        }

        public void follow(int followerId, int followeeId) {
            if (!users.containsKey(followerId)) users.put(followerId, new HashSet<Integer>());
            users.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (users.containsKey(followerId)) {
                if (users.get(followerId).contains(followeeId)) {
                    users.get(followerId).remove(followeeId);
                }
            }
        }
    }
}
