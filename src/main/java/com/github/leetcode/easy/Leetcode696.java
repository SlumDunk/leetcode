package com.github.leetcode.easy;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's
 * and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 * <p>
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * <p>
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * <p>
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note:
 * <p>
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 *
 * @author liuzhongda
 */
public class Leetcode696 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int countBinarySubstrings(String s) {
        //就是统计连续的0或者1的个数存进一个数组，那么总的组合数就是相邻的个数的最小值的加和。举个例子来说：
        //比如001101000这个字符串，那么统计数组中的值应该是2,2,1,1,3
        //那么总的次数就是min（2,2）+min（2,1）+min（1,1）+min（1,3），因为要找的是1和0相等的组合，所以一定在交界处出现，并且个数等于0和1中最小的那个，比如00011那么0的个数右3个，1的个数有2个，那么组合就有01,0011这两个，因为再多了1的个数就不够用了，所以个数是min（3,2），懂了吧！
        int len = s.length();
        if (len <= 1)
            return 0;
        char[] sc = s.toCharArray();
        int i = 0, prev = -1, res = 0;
        while (i < len) {
            int j = i;
            char c = sc[i];
            // 统计相同元素的个数
            while (i < len && sc[i] == c)
                i++;
            //计算相同连续字符串长度
            int cur = i - j;
            //上一个连续字符串的长度，二者取小值
            if (prev != -1)
                res += Math.min(prev, cur);
            prev = cur;
        }
        return res;
    }
}
