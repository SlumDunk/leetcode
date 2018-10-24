package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 12:49
 * @Description: The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 * <p>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 * <p>
 * 在n == 1的时候，序列为 0 1，其中1 = 1+0；
 * <p>
 * 在n == 2的时候，序列为 0 1 3 2，其中3 = 2+1 , 2 = 2+0；
 * <p>
 * 在n == 3的时候，序列为 0 1 3 2 6 7 5 4，其中6 = 4+2 , 7 = 4+3 , 5 = 4+1 , 4 = 4+0 ；
 * ---------------------
 * 作者：xuyueqing1225
 * 来源：CSDN
 * 原文：https://blog.csdn.net/xuyueqing1225/article/details/77725583
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        result.add(0);
        int num = 1;
        for (int x = 0; x < n; x++) {
            int length = result.size();
            for (int i = length - 1; i >= 0; i--)
                result.add(result.get(i) + num);
            num *= 2;
        }
        return result;
    }

}
