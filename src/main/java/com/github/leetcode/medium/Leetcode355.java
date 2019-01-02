package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 14:02
 * @Description: Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each val in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
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
        /**
         * 全局推特序号sequence生成器
         */
        int number = 0;
        /**
         * 维护用户和粉丝的关系
         */
        Map<Integer, Set<Integer>> users;  // user --> user follow list
        /**
         * 维护用户和发表的推特的关系
         */
        Map<Integer, List<Tweet>> tweets; // user -->  users' tweets

        /**
         * 推特类
         */
        public class Tweet {
            /**
             * 用户id
             */
            int userId;
            /**
             * 推特id
             */
            int tweetId;
            /**
             * 推特序号 代表先后顺序
             */
            int num;

            public Tweet(int userId, int tweetId) {
                this.userId = userId;
                this.tweetId = tweetId;
                this.num = number++;
            }
        }

        /**
         * 初始化数据结构
         */
        public Twitter() {
            users = new HashMap<>();
            tweets = new HashMap<>();
        }

        /**
         * 用户userId发表推特tweetId
         *
         * @param userId
         * @param tweetId
         */
        public void postTweet(int userId, int tweetId) {
            if (!tweets.containsKey(userId)) tweets.put(userId, new LinkedList<Tweet>());
            tweets.get(userId).add(new Tweet(userId, tweetId));
        }

        /**
         * 获取该用户最近相关的推特，由该用户发表的或者是他关注的人发表的
         *
         * @param userId
         * @return
         */
        public List<Integer> getNewsFeed(int userId) {
            //最小堆
            PriorityQueue<Tweet> heap = new PriorityQueue<Tweet>((t1, t2) -> t1.num - t2.num);
            //获取用户关注的人
            Set<Integer> followees = users.get(userId) == null ? new HashSet<Integer>() : users.get(userId);
            followees.add(userId);
            for (int uid : followees) {
                List<Tweet> tweetList = tweets.get(uid);
                if (tweetList != null) {
                    for (Tweet tweet : tweetList) {
                        //未足十条，继续添加
                        if (heap.size() < 10) {
                            heap.add(tweet);
                        } else {//超过十条，优先级低的出队，优先级高的进队
                            if (tweet.num > heap.peek().num) {
                                heap.poll();
                                heap.add(tweet);
                            }
                        }
                    }
                }
            }
            //返回最近的十条推特
            int count = 0;
            LinkedList<Integer> list = new LinkedList<Integer>();
            while (!heap.isEmpty() && count++ < 10) {
                list.addFirst(heap.poll().tweetId);
            }
            return list;
        }

        /**
         * follower 关注了 followeeId
         *
         * @param followerId 关注者
         * @param followeeId 被关注者
         */
        public void follow(int followerId, int followeeId) {
            if (!users.containsKey(followerId)) users.put(followerId, new HashSet<Integer>());
            users.get(followerId).add(followeeId);
        }

        /**
         * follower取消关注followee
         *
         * @param followerId
         * @param followeeId
         */
        public void unfollow(int followerId, int followeeId) {
            if (users.containsKey(followerId)) {
                if (users.get(followerId).contains(followeeId)) {
                    users.get(followerId).remove(followeeId);
                }
            }
        }
    }
}
