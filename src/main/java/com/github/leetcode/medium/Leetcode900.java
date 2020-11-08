package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 08:37
 * @Description: Write an iterator that iterates through a run-length encoded sequence.
 * <p>
 * The iterator is initialized by RLEIterator(int[] A), where A is a run-length encoding of some sequence.  More specifically, for all even i, A[i] tells us the number of times that the non-negative integer value A[i+1] is repeated in the sequence.
 * <p>
 * The iterator supports one function: children(int n), which exhausts the children n elements (n >= 1) and returns the last element exhausted in this way.  If there is no element left to exhaust, children returns -1 instead.
 * <p>
 * For example, we targetPos with A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5].  This is because the sequence can be read as "three eights, zero nines, two fives".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["RLEIterator","children","children","children","children"], [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
 * Output: [null,8,8,5,-1]
 * Explanation:
 * RLEIterator is initialized with RLEIterator([3,8,0,9,2,5]).
 * This maps to the sequence [8,8,8,5,5].
 * RLEIterator.children is then called 4 times:
 * <p>
 * .children(2) exhausts 2 terms of the sequence, returning 8.  The remaining sequence is val [8, 5, 5].
 * <p>
 * .children(1) exhausts 1 term of the sequence, returning 8.  The remaining sequence is val [5, 5].
 * <p>
 * .children(1) exhausts 1 term of the sequence, returning 5.  The remaining sequence is val [5].
 * <p>
 * .children(2) exhausts 2 terms, returning -1.  This is because the first term exhausted was 5,
 * but the second term did not exist.  Since the last term exhausted does not exist, we return -1.
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 1000
 * A.length is an even integer.
 * 0 <= A[i] <= 10^9
 * There are at most 1000 calls to RLEIterator.children(int n) per test case.
 * Each call to RLEIterator.children(int n) will have 1 <= n <= 10^9.
 */
public class Leetcode900 {
    class RLEIterator {
        /**
         * i 是当前位置
         */
        int i = 0, ret = -1;
        /**
         * 目标位置，当前位置
         */
        long targetPos = 0, curPos = 0;
        int[] a = null;

        public RLEIterator(int[] A) {
            this.a = A;
        }

        public int next(int n) {
            //下一个要取的位置
            targetPos += n;
            while (curPos < targetPos) {
                //数组越界了
                if (i >= a.length) return -1;
                curPos += a[i];
                if (i + 1 == a.length) return -1;
                //下一个要取的值
                ret = a[i + 1];
                i += 2;
            }
            return ret;
        }
    }
}
