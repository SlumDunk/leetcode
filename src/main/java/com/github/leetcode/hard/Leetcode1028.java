package com.github.leetcode.hard;

import com.github.leetcode.vo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 23:58
 * @Description: We run a preorder depth first search on the root of a binary tree.
 * <p>
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
 * <p>
 * If a node has only one child, that child is guaranteed to be the left child.
 * <p>
 * Given the output S of this traversal, recover the tree and return its root.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the original tree is between 1 and 1000.
 * Each node will have a value between 1 and 10^9.
 */
public class Leetcode1028 {
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;
        Map<Integer, TreeNode> map = new HashMap<>();
        int end = 0;
        while (end < S.length() && S.charAt(end) != '-') end++;
        TreeNode root = new TreeNode(Integer.valueOf(S.substring(0, end)));
        map.put(1, root);
        while (end < S.length()) {
            int prev = end;
            while (S.charAt(end) == '-') end++;
            //父节点所在的层级
            int level = end - prev;
            TreeNode parent = map.get(level);
            //数字的开始位置
            prev = end;
            while (end < S.length() && S.charAt(end) != '-') end++;
            TreeNode child = new TreeNode(Integer.valueOf(S.substring(prev, end)));
            if (parent.left == null) parent.left = child;
            else parent.right = child;
            //每一层保留最新的一个节点就可以
            map.put(level + 1, child);
        }
        return root;
    }
}
