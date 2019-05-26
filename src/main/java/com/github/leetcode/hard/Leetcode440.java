package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 20:44
 * @Description: Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 * <p>
 * Note: 1 ≤ k ≤ n ≤ 109.
 * <p>
 * Example:
 * <p>
 * Input:
 * n: 13   k: 2
 * <p>
 * Output:
 * 10
 * <p>
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 */
public class Leetcode440 {
    public static void main(String[] args) {
        Leetcode440 leetcode440 = new Leetcode440();
        leetcode440.findKthNumber(13, 2);
    }

    private int kthNum;
    private int visited = -1;

    public int findKthNumber(int n, int k) {
        int digits = getDigits(n);
        dfs(0, digits, 0, 0, n, k);
        return kthNum;
    }

    /**
     * @param curLevel
     * @param maxLevel
     * @param digit    余数
     * @param value    商
     * @param n
     * @param k
     */
    private void dfs(int curLevel, int maxLevel, int digit, int value, int n, int k) {
        if (curLevel > maxLevel || visited >= k) {
            return;
        }
        int newvalue = value * 10 + digit;
        if (0 < curLevel && curLevel < maxLevel) {
            //最左边界
            int leftBottom = getBottomValue(newvalue, curLevel, maxLevel, 0);
            //最右边界
            int rightBottom = getBottomValue(newvalue, curLevel, maxLevel, 9);
            int subtreeNodes = getNodes(curLevel, maxLevel - 1) + (leftBottom > n ? 0 : Math.min(n, rightBottom) - leftBottom + 1);
            if (visited + subtreeNodes < k) {
                visited += subtreeNodes;
                return;
            }
        }
        if (++visited == k) {
            kthNum = newvalue;
            return;
        }
        //首位不能为0
        for (int i = curLevel == 0 ? 1 : 0; i < 10; i++) {
            dfs(curLevel + 1, maxLevel, i, newvalue, n, k);

        }
    }

    /**
     * 获取子树节点数
     *
     * @param curLevel
     * @param maxLevel
     * @return
     */
    private int getNodes(int curLevel, int maxLevel) {
        int total = 0;
        int here = 1;
        for (int i = curLevel; i <= maxLevel; i++) {
            total += here;
            here *= 10;
        }
        return total;
    }

    /**
     * @param value
     * @param curLevel
     * @param maxLevel
     * @param addup
     * @return
     */
    private int getBottomValue(int value, int curLevel, int maxLevel, int addup) {
        for (int i = 0; i < maxLevel - curLevel; i++) {
            value = value * 10 + addup;
        }
        return value;
    }

    /**
     * 获取位数
     *
     * @param n
     * @return
     */
    private int getDigits(int n) {
        int digits = 0;
        while (n > 0) {
            digits++;
            n /= 10;
        }
        return digits;
    }
}
