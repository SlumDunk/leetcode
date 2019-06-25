package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/24/19 21:41
 * @Description: N cars are going to the same destination along a one lane road.  The destination is target miles away.
 * <p>
 * Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
 * <p>
 * The distance between these two cars is ignored - they are assumed to have the same position.
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * <p>
 * <p>
 * How many car fleets will arrive at the destination?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 and 8 become a fleet, meeting each other at 12.
 * The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 and 3 become a fleet, meeting each other at 6.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 * <p>
 * Note:
 * <p>
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * All initial positions are different.
 */
public class Leetcode853 {
    class Car {
        /**
         * 开始位置
         */
        int pos;
        /**
         * 到终点需要的时间
         */
        double hourNeed;

        Car(int pos, double hour) {
            this.pos = pos;
            this.hourNeed = hour;
        }
    }

    /**
     * 按出发位置倒序排列
     */
    class carComparator implements Comparator<Car> {
        public int compare(Car a, Car b) {
            return b.pos - a.pos;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || speed == null || position.length == 0 || speed.length == 0) return 0;
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            carList.add(new Car(position[i], (double) ((double) target - (double) position[i]) / (double) speed[i]));
        }
        Collections.sort(carList, new carComparator());

        int count = 1;
        //后一辆车位置
        int index = 1;
        //当前车流到达终点的最长时间
        double curMaxHour = carList.get(0).hourNeed;
        while (index < carList.size()) {
            //后面的车能追上前面的车，所以能构成一个车流
            while (index < carList.size() && (carList.get(index).hourNeed <= curMaxHour)) {
                index++;
                if (index == carList.size()) return count;
            }

            curMaxHour = carList.get(index).hourNeed;
            count++;
            index++;
        }
        return count;
    }
}
