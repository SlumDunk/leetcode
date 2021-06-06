package com.github.leetcode.medium;

/**
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: hour = 12, minutes = 30
 * Output: 165
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: hour = 3, minutes = 30
 * Output: 75
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 * Example 4:
 * <p>
 * Input: hour = 4, minutes = 50
 * Output: 155
 * Example 5:
 * <p>
 * Input: hour = 12, minutes = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * Answers within 10^-5 of the actual value will be accepted as correct.
 */
public class Leetcode1344 {
    public double angleClock(int hour, int minutes) {
        double degreeHour = (hour % 12 + (double) (minutes) / 60) * 30;
        double degreeMinutes = (double) (minutes) / 60 * 360;

        double max = Math.max(degreeHour, degreeMinutes);
        double min = Math.min(degreeHour, degreeMinutes);

        return Math.min(max - min, min + 360 - max);
    }
}
