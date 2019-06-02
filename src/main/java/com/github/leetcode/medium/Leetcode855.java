package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 21:25
 * @Description: In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 * <p>
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)
 * <p>
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student sits at the last seat number 5.
 * ​​​​​​​
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 */
public class Leetcode855 {
    class ExamRoom {
        int N;
        private List<Integer> takenSeats;

        public ExamRoom(int N) {
            this.N = N;
            takenSeats = new ArrayList<>();
        }

        public int seat() {
            if (takenSeats.isEmpty()) {
                takenSeats.add(0);
                return 0;
            }
            int idx = 0;
            int pos = 0;
            int diff = takenSeats.get(0);

            for (int i = 0; i < takenSeats.size() - 1; i++) {
                //list相邻位置差/2
                int curDiff = (takenSeats.get(i + 1) - takenSeats.get(i)) / 2;
                if (curDiff > diff) {
                    //更新下一个要插入的位置
                    idx = i + 1;
                    pos = takenSeats.get(i) + curDiff;
                    diff = curDiff;
                }
            }
            if ((N - 1 - takenSeats.get(takenSeats.size() - 1)) > diff) {
                idx = takenSeats.size();
                pos = N - 1;
            }
            takenSeats.add(idx, pos);
            return pos;
        }

        public void leave(int p) {
            Iterator<Integer> iterator = takenSeats.iterator();
            while (iterator.hasNext()) {
                if (p == iterator.next()) {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}
