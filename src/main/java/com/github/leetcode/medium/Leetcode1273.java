package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * A tree rooted at node 0 is given as follows:
 * <p>
 * The number of nodes is nodes;
 * The value of the i-th node is value[i];
 * The parent of the i-th node is parent[i].
 * Remove every subtree whose sum of values of nodes is zero.
 * <p>
 * After doing so, return the number of nodes remaining in the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-2]
 * Output: 6
 * Example 3:
 * <p>
 * Input: nodes = 5, parent = [-1,0,1,0,0], value = [-672,441,18,728,378]
 * Output: 5
 * Example 4:
 * <p>
 * Input: nodes = 5, parent = [-1,0,0,1,1], value = [-686,-842,616,-739,-746]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nodes <= 10^4
 * parent.length == nodes
 * 0 <= parent[i] <= nodes - 1
 * parent[0] == -1 which indicates that 0 is the root.
 * value.length == nodes
 * -10^5 <= value[i] <= 10^5
 * The given input is guaranteed to represent a valid tree.
 */
public class Leetcode1273 {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        List<Integer>[] children = new ArrayList[nodes];
        for (int i = 1; i < nodes; i++) {
            if (children[parent[i]] == null) {
                children[parent[i]] = new ArrayList<>();
            }
            children[parent[i]].add(i);
        }

        return nodes - dfs(children, 0, value)[2];
    }

    /**
     * int[0]:  sum of subtree with node as root
     * int[1]: count of nodes of subtree with node as root
     * int[2]: count of removed nodes
     * @param children
     * @param node
     * @param value
     * @return
     */
    private int[] dfs(List<Integer>[] children, int node, int[] value) {
        if (children[node] == null) {
            return new int[]{value[node], 1, value[node] == 0 ? 1 : 0};
        }
        int sum = value[node];
        int count = 1;
        int removed = 0;
        for (int child :
                children[node]) {
            int[] subTree = dfs(children, child, value);
            sum += subTree[0];
            count += subTree[1];
            removed += subTree[2];
        }

        if (sum == 0) {
            removed = count;
        }
        return new int[]{sum, count, removed};
    }
}
