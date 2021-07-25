package com.github.leetcode.medium;

import com.github.leetcode.vo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.
 * <p>
 * Return the linked list after the deletions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,2]
 * Output: [1,3]
 * Explanation: 2 appears twice in the linked list, so all 2's should be deleted. After deleting all 2's, we are left with [1,3].
 * Example 2:
 * <p>
 * <p>
 * Input: head = [2,1,1,2]
 * Output: []
 * Explanation: 2 and 1 both appear twice. All the elements should be deleted.
 * Example 3:
 * <p>
 * <p>
 * Input: head = [3,2,2,1,3,2,4]
 * Output: [1,4]
 * Explanation: 3 appears twice and 2 appears three times. After deleting all 3's and 2's, we are left with [1,4].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 105]
 * 1 <= Node.val <= 105
 */
public class Leetcode1836 {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        // 先扫一遍，看看哪些值重复
        Set<Integer> unique = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (unique.contains(cur.val)) {
                duplicate.add(cur.val);
            } else {
                unique.add(cur.val);
            }
            cur = cur.next;
        }
        ListNode ans = null;
        ListNode pre = null;
        cur = head;
        while (cur != null) {
            if (!duplicate.contains(cur.val)) {
                if (pre != null) {
                    pre.next = cur;
                } else {
                    ans = cur;
                }
                pre = cur;
            }
            cur = cur.next;
        }
        if (pre != null && pre.next != null && duplicate.contains(pre.next.val)) {
            pre.next = null;
        }
        return ans;
    }
}
