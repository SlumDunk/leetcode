package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/28/18 10:32
 * @Description: There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 1
 * Explanation:
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 * <p>
 * So you should return 1, because there is only one bulb is on.
 * 当n=6时，尝试列出所有状态
 * <p>
 * 初始状态 [off off off off off off]
 * <p>
 * 第一次:    [on on on on on on]
 * <p>
 * 第二次： [on off on off on off]
 * <p>
 * 第三次： [on off off off on on]
 * <p>
 * 第四次:    [on off off on on on]
 * <p>
 * 第五次:    [on off off on off on]
 * <p>
 * 第六次:    [on off off on off off]
 * <p>
 * 可以看到对第k个灯泡，当次数是k的因数时，灯泡状态会发生改变，经过六次变化后只有1,4两盏灯泡亮着，而1,4恰巧是完全平方数，那么这到底是否纯粹是巧合？
 * <p>
 * 我们知道经过偶数次变换后灯泡状态相当于不变，经过奇数次变换后灯泡状态才发生改变，所以最终亮着的灯泡k满足条件：k的因数有奇数个。这样的k必然是完全平方数。
 * <p>
 * 因此，题目相当于求1~n范围内完全平方数个数。
 */
public class Leetcode319 {
    public int bulbSwitch(int n) {
        //找规律
        return (int) Math.sqrt(n);
    }
}
