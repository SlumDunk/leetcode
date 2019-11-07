package com.github.interview.purestorage;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/15/19 14:17
 * @Description:
 */
public class ValidateLock {
    public static void main(String[] args) {
        String[] sequences = new String[3];
        System.out.println(checkLockSequence(sequences));
    }

    private static int checkLockSequence(String[] sequences) {
        if (sequences == null || sequences.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < sequences.length; i++) {
            String[] curState = sequences[i].split(" ");
            String state = curState[0];
            String id = curState[1];

            if ("ACQUIRE".equals(state)) {
                if (set.contains(id)) {
                    return i + 1;
                }
                set.add(id);
                stack.push(id);
            } else {
                if (!stack.isEmpty() && stack.peek().equals(id)) {
                    set.remove(stack.pop());
                } else {
                    return i + 1;
                }
            }
        }
        return stack.isEmpty() == true ? 0 : sequences.length + 1;
    }
}
