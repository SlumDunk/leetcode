package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * <p>
 * The cloned tree is a copy of the original tree.
 * <p>
 * Return a reference to the same node in the cloned tree.
 * <p>
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 * <p>
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: tree = [7,4,3,null,null,6,19], target = 3
 * Output: 3
 * Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
 * Example 2:
 * <p>
 * <p>
 * Input: tree = [7], target =  7
 * Output: 7
 * Example 3:
 * <p>
 * <p>
 * Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * Output: 4
 * Example 4:
 * <p>
 * <p>
 * Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
 * Output: 5
 * Example 5:
 * <p>
 * <p>
 * Input: tree = [1,2,null,3], target = 2
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 10^4].
 * The values of the nodes of the tree are unique.
 * target node is a node from the original tree and is not null.
 */
public class Leetcode1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
