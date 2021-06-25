package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * <p>
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * boolean hasPrev() Returns true if there exists a number in the traversal to the left of the pointer, otherwise returns false.
 * int prev() Moves the pointer to the left, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 * <p>
 * You may assume that next() and prev() calls will always be valid. That is, there will be at least a next/previous number in the in-order traversal when next()/prev() is called.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input
 * ["BSTIterator", "next", "next", "prev", "next", "hasNext", "next", "next", "next", "hasNext", "hasPrev", "prev", "prev"]
 * [[[7, 3, 15, null, null, 9, 20]], [null], [null], [null], [null], [null], [null], [null], [null], [null], [null], [null], [null]]
 * Output
 * [null, 3, 7, 3, 7, true, 9, 15, 20, false, true, 15, 9]
 * <p>
 * Explanation
 * // The underlined element is where the pointer currently is.
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]); // state is   [3, 7, 9, 15, 20]
 * bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 3
 * bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 7
 * bSTIterator.prev(); // state becomes [3, 7, 9, 15, 20], return 3
 * bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 7
 * bSTIterator.hasNext(); // return true
 * bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 9
 * bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 15
 * bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 20
 * bSTIterator.hasNext(); // return false
 * bSTIterator.hasPrev(); // return true
 * bSTIterator.prev(); // state becomes [3, 7, 9, 15, 20], return 15
 * bSTIterator.prev(); // state becomes [3, 7, 9, 15, 20], return 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 105].
 * 0 <= Node.val <= 106
 * At most 105 calls will be made to hasNext, next, hasPrev, and prev.
 * <p>
 * <p>
 * Follow up: Could you solve the problem without precalculating the values of the tree?
 */
public class Leetcode1586 {
    class BSTIterator {
        //firstly inorder traversal and put elements into list in order.
        int idx = 0;
        List<Integer> list = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            TreeNode temp = root;
            inorderTraversal(temp);
            list.add(0, list.get(0) - 1);      //initial pointer is at idx 0
        }

        public void inorderTraversal(TreeNode root) {
            if (root == null) return;
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }

        public boolean hasNext() {
            if (idx != list.size() - 1) return true;
            return false;
        }

        public int next() {
            idx++;

            if (idx < list.size()) return list.get(idx);
            return -1;
        }

        public boolean hasPrev() {
            if (idx == 0 || idx == 1) return false;
            return true;
        }

        public int prev() {
            idx--;
            return list.get(idx);
        }
    }
}
