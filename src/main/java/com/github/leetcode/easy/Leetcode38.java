package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/25/18 16:32
 * @Description: The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * Accepted
 * 241,321
 * Submissions
 * 623,944
 */
public class Leetcode38 {
    public String countAndSay(int n) {
        if (n < 1)
            return null;
        //当前字符串
        String curRes = "1";
        //迭代次数
        for (int i = 2; i <= n; i++) {
            //存储中间结果
            StringBuilder res = new StringBuilder();
            //第一个字符已经放进去了
            int count = 1;
            for (int j = 1; j < curRes.length(); j++) {
                //j和前面的字符是否相等,继续加
                if (curRes.charAt(j) == curRes.charAt(j - 1)) {
                    count++;
                } else {
                    //计数+数字本身
                    res.append(count);
                    res.append(curRes.charAt(j - 1));
                    count = 1;//count置位为1,因为j已经放进去了
                }
            }
            //最后一次的数字放进来
            res.append(count);
            res.append(curRes.charAt(curRes.length() - 1));
            //将新的字符串赋值给curRes
            curRes = res.toString();
        }
        return curRes;
    }
}
