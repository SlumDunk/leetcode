package com.github.interview.google;

/**
 * @Author: zerongliu
 * @Date: 12/10/18 10:13
 * @Description: 给一个数组， 问有多少个数能跳到最后。 奇数次跳时 只能跳到后面比当前数大的数字里最小的。 偶数次跳时，只能跳到后面比当前数小的数字里最大的。 有重复数字时，跳index最小的。最后一个数也算， 不用跳已经在最后了。
 * [10,13,12,14,15]
 */
public class Google7 {

    public static void main(String[] args) {
        Google7 google7 = new Google7();
        int[] input = {10, 13, 12, 14, 15};
        System.out.println(google7.findAll(input));
    }

    int num = 0;

    public int findAll(int[] input) {
        int len = input.length;
        for (int i = 0; i < len; i++) {
            findNumberOfJumps(input, i, Boolean.TRUE);
        }
        return num;
    }

    /**
     * use parse to find the result
     *
     * @param input
     * @param currentIndex
     * @param isOdd
     * @return
     */
    private void findNumberOfJumps(int[] input, int currentIndex, Boolean isOdd) {
        if (currentIndex == input.length - 1) {
            num++;
            return;
        }
        if (currentIndex == -1) {
            return;
        } else {
            int nextIndex = -1;
            if (isOdd) {//odd jump, find the smallest one of the numbers larger than current
                nextIndex = findSmallestOfLarge(currentIndex + 1, input, input[currentIndex]);
            } else {//even jump, find the largest of the numbers smaller than current
                nextIndex = findLargestOfSmall(currentIndex + 1, input, input[currentIndex]);
            }
            findNumberOfJumps(input, nextIndex, !isOdd);
        }
    }

    /**
     * find the largest one of the numbers which smaller than pivot in subarray [startIndex...input.length)
     *
     * @param startIndex
     * @param input
     * @param pivot
     * @return
     */
    private int findLargestOfSmall(int startIndex, int[] input, int pivot) {
        int index = -1;
        int largest = Integer.MIN_VALUE;
        for (int i = startIndex; i < input.length; i++) {
            if (input[i] < pivot && input[i] >= largest) {
                if ((input[i] == largest && index == -1) || input[i] > largest) {
                    index = i;
                    largest = input[i];
                }
            }
        }
        return index;
    }

    /**
     * find the smallest one of the numbers which larger than pivot in subarray [startIndex...input.length)
     *
     * @param startIndex start startIndex
     * @param input      array
     * @param pivot      current element
     * @return
     */
    private int findSmallestOfLarge(int startIndex, int[] input, int pivot) {
        int index = -1;
        int smallest = Integer.MAX_VALUE;
        for (int i = startIndex; i < input.length; i++) {
            if (input[i] > pivot && input[i] <= smallest) {
                if ((input[i] == smallest && index == -1) || input[i] < smallest) {
                    index = i;
                    smallest = input[i];
                }
            }
        }
        return index;
    }
}
