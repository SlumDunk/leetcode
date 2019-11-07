package com.github.interview.purestorage;

/**
 * @Author: zerongliu
 * @Date: 10/15/19 14:08
 * @Description:
 */
public class Scores {
    public static void main(String[] args) {
        int result = 0;
        int num = 92228763;
        result += rules0(num);
        result += rules1(num);
        result += rules2(num);
        result += rules3(num);
        result += rules4(num);
        System.out.println(result);
    }

    private static int rules4(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] - '0';
            if (tmp % 2 == 0) {
                sum += 3;
            }
        }
        return sum;
    }

    private static int rules3(int num) {
        if (num % 3 == 0) {
            return 4;
        }
        return 0;
    }

    private static int rules2(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int sum = 0;
        int curLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == -1) {
                curLength++;
            } else {
                sum += curLength * curLength;
                curLength = 1;
            }
        }

        sum += curLength * curLength;
        return sum;
    }

    private static int rules1(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == '2' && nums[i + 1] == '2') {
                sum += 6;
            }
        }
        return sum;
    }

    public static int rules0(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '7') {
                sum += 5;
            }
        }
        return sum;
    }
}
