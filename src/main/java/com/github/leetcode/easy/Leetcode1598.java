package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 16:39
 * @Description: The Leetcode file system keeps a log each time some user performs a change folder operation.
 * <p>
 * The operations are described below:
 * <p>
 * "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
 * "./" : Remain in the same folder.
 * "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
 * You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
 * <p>
 * The file system starts in the main folder, then the operations in logs are performed.
 * <p>
 * Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: logs = ["d1/","d2/","../","d21/","./"]
 * Output: 2
 * Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: logs = ["d1/","d2/","./","d3/","../","d31/"]
 * Output: 3
 * Example 3:
 * <p>
 * Input: logs = ["d1/","../","../","../"]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= logs.length <= 103
 * 2 <= logs[i].length <= 10
 * logs[i] contains lowercase English letters, digits, '.', and '/'.
 * logs[i] follows the format described in the statement.
 * Folder names consist of lowercase English letters and digits.
 */
public class Leetcode1598 {
    public int minOperations(String[] logs) {
        List<String> operationList = new ArrayList<>();
        for (String operation :
                logs) {
            if (!operation.equals("./")) {
                if (operation.equals("../")) {
                    if (operationList.size() > 0) {
                        operationList.remove(operationList.size() - 1);
                    }
                } else {
                    operationList.add(operation);
                }
            }
        }
        return operationList.size();
    }
}
