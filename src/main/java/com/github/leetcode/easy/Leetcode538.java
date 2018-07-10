package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original 
 * key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

 * @author liuzhongda
 *
 */
public class Leetcode538 {
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(13);
		root.left=left;
		root.right=right;
		convertBST(root);
		
	}

	public static TreeNode convertBST(TreeNode root) {
		List<Integer> valList = new ArrayList<>();
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);
		TreeNode tmpNode = null;
		while ((tmpNode = nodeQueue.poll()) != null) {
			valList.add(tmpNode.val);
			if (tmpNode.left != null)
				nodeQueue.add(tmpNode.left);
			if (tmpNode.right != null)
				nodeQueue.add(tmpNode.right);
		}
		Collections.sort(valList);
		
		nodeQueue.add(root);		
		while ((tmpNode = nodeQueue.poll()) != null) {
			tmpNode.val=sumOfGreaterVal(valList,tmpNode.val);
			if (tmpNode.left != null)
				nodeQueue.add(tmpNode.left);
			if (tmpNode.right != null)
				nodeQueue.add(tmpNode.right);
		}
		

		return root;
	}

	private static int sumOfGreaterVal(List<Integer> valList, int val) {
		// TODO Auto-generated method stub
		int sum = val;
		for (int i = valList.lastIndexOf(val) + 1; i < valList.size(); i++) {
			sum += valList.get(i);
		}
		return sum;
	}
}
