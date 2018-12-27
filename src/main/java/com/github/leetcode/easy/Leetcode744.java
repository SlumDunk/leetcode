package com.github.leetcode.easy;

/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class Leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        //二分查找，没有找到比目标值大的，返回第一个元素
        int left = 0, right = letters.length - 1;
        //找到比目标值大的最近的位置
        //这里不能存在等号条件，因为mid会作为上边界的情况，有等号会出现死循环
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                left = mid + 1;
            } else if (letters[mid] > target) {//比目标值大
                right = mid;
            } else {//比目标值小
                left = mid + 1;
            }
        }
        //如果最邻近的位置元素比目标值大，返回
        if (letters[left] > target) {
            return letters[left];
        } else {
            return letters[0];
        }
    }
}
