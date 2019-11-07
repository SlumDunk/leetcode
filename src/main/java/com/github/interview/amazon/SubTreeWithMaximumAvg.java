package com.github.interview.amazon;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 13:55
 * @Description:
 */
public class SubTreeWithMaximumAvg {
    static class TreeNode {
        int val;
        TreeNode[] children;

        TreeNode(int val, TreeNode[] children) {
            this.val = val;
            if (children == null)
                this.children = new TreeNode[0];
            else
                this.children = children;
        }
    }

    public static TreeNode maxNode;
    public static double maxAvg;

    public static void main(String[] args) {
        TreeNode n11 = new TreeNode(11, null);
        TreeNode n2 = new TreeNode(2, null);
        TreeNode n3 = new TreeNode(3, null);
        TreeNode n15 = new TreeNode(15, null);
        TreeNode n8 = new TreeNode(8, null);

        TreeNode n12 = new TreeNode(12, new TreeNode[]{n11, n2, n3});
        TreeNode n18 = new TreeNode(18, new TreeNode[]{n15, n8});

        TreeNode n20 = new TreeNode(20, new TreeNode[]{n12, n18});

        TreeNode node = solution(n20);
        System.out.println(node.val);
    }

    public static TreeNode solution(TreeNode root) {
        if (root == null)
            return null;
        maxAvg = Double.MIN_VALUE;
        maxNode = null;

        subtree(root);
        return maxNode;

    }

    public static double[] subtree(TreeNode node) { //return "sum" and "# of nodes" in the subtree rooted at "node".

        if (node == null)
            return new double[]{0.0, 0.0};

        double sum = node.val;
        double cnt = 1;

        if (node.children.length == 0) {
            // only non-leaf nodes can be counted as a "subtree"
            return new double[]{sum, cnt};
        }

        for (TreeNode chd : node.children) {
            double[] sub = subtree(chd);
            sum += sub[0];
            cnt += sub[1];
        }

        double avg = sum / cnt;
        if (avg > maxAvg) {
            maxAvg = avg;
            maxNode = node;
        }

        return new double[]{sum, cnt};
    }

}
