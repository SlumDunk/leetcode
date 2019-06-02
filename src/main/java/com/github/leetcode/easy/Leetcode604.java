package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 09:40
 * @Description: Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
 * <p>
 * The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
 * <p>
 * next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 * <p>
 * Note:
 * Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * <p>
 * Example:
 * <p>
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * <p>
 * iterator.next(); // return 'L'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 't'
 * iterator.next(); // return 'C'
 * iterator.next(); // return 'o'
 * iterator.next(); // return 'd'
 * iterator.hasNext(); // return true
 * iterator.next(); // return 'e'
 * iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 */
public class Leetcode604 {
    class StringIterator {
        private String s;
        private int idx, count;

        public StringIterator(String compressedString) {
            s = compressedString;
            idx = -1;
            count = 0;
            buildNumber();
        }

        private void buildNumber() {
            idx++;
            while (idx < s.length() && !Character.isLetter(s.charAt(idx))) idx++;
            int count = 0, i = idx + 1;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                int digit = (s.charAt(i) - '0');
                count = count * 10 + digit;
                i++;
            }
            this.count = count;
        }

        public char next() {
            if (!hasNext()) return ' ';
            if (count == 1) {
                char c = s.charAt(idx);
                buildNumber();
                return c;
            } else {
                count--;
                return s.charAt(idx);
            }
        }

        public boolean hasNext() {
            return idx < s.length();
        }
    }
}
