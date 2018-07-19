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
        char result = findNextGreatestLetter(letters, target, 0, letters.length - 1);
        return result;
    }

    private char findNextGreatestLetter(char[] letters, char target, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (letters[mid] > target) {
                return findNextGreatestLetter(letters, target, 0, mid);
            } else {
                return findNextGreatestLetter(letters, target, mid + 1, high);
            }
        } else {
            if (letters[low] > target) {
                return letters[low];
            } else {
                return letters[0];
            }
        }
    }
}
