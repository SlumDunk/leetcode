package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 23:26
 * @Description: Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * <p>
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * Logger logger = new Logger();
 * <p>
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class Leetcode359 {
    class Logger {

        Map<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            map = new HashMap<>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!map.containsKey(message) || (timestamp - map.get(message)) >= 10) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        }
    }

}
