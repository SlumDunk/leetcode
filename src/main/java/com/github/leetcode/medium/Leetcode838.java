package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 10:58
 * @Description: There are N dominoes in a line, and we place each domino vertically upright.
 * <p>
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * <p>
 * <p>
 * <p>
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * <p>
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * <p>
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * <p>
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 * <p>
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * <p>
 * Return a string representing the final state.
 * <p>
 * Example 1:
 * <p>
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * Example 2:
 * <p>
 * Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * Note:
 * <p>
 * 0 <= N <= 10^5
 * String dominoes contains only 'L', 'R' and '.'
 */
public class Leetcode838 {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() < 2) {
            return dominoes;
        }

        char[] array = dominoes.toCharArray();
        int left = 0, right = 0;
        while (right < array.length) {
            if (array[right] == 'L' || right == array.length - 1 || array[right] == 'R') {
                pushDominoes(array, left, right);
                left = right;
            }

            ++right;
        }

        return new String(array);
    }

    /**
     * @param array
     * @param left
     * @param right
     */
    private void pushDominoes(char[] array, int left, int right) {
        //最左的向右推，最右的向左推
        boolean pushRight = array[left] == 'R', pushLeft = array[right] == 'L';
        if (pushLeft && pushRight) {// -> <-
            //除了重点，两侧都不平衡
            for (int i = 0; i < (right - left + 1) / 2; ++i) {
                array[left + i] = 'R';
                array[right - i] = 'L';
            }
        } else if (pushLeft || pushRight) {//<- <- ||-> ->
            for (int i = left; i <= right; ++i) {
                array[i] = pushLeft ? 'L' : 'R';
            }
        }// <- ->
    }
}
