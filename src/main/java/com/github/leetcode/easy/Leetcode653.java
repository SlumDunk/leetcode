package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to 
 * the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 * @author liuzhongda
 *
 */
public class Leetcode653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean findTarget(TreeNode root, int k) {
		Map<Integer, Integer> valMap = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
			TreeNode tmpNode = null;
			while ((tmpNode = queue.poll()) != null) {
				if (valMap.get(tmpNode.val) != null) {
					valMap.put(tmpNode.val, valMap.get(tmpNode.val) + 1);
				} else {
					valMap.put(tmpNode.val, 1);
				}
				if (tmpNode.left != null)
					queue.add(tmpNode.left);
				if (tmpNode.right != null)
					queue.add(tmpNode.right);
			}
		}

		for (Integer key : valMap.keySet()) {
			Integer completeVal = valMap.get(k - key);
			if (completeVal != null) {
				if ((key == k - key && completeVal == 1)) {
					return false;
				} else {
					return true;
				}
			}
		}

		return false;
	}

}
