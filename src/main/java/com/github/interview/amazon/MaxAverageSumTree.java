package com.github.interview.amazon;

import java.util.ArrayList;

/**
 * @Author: zerongliu
 * @Date: 4/9/19 20:58
 * @Description:
 */
public class MaxAverageSumTree {
    class Result {
        CategoryNode node;
        int sum;
        int size;

        public Result(CategoryNode node, int sum, int size) {
            this.node = node;
            this.sum = sum;
            this.size = size;
        }
    }

    private Result res = null;

    public CategoryNode getMostPopularNode(CategoryNode rootCategory) {
        if (rootCategory == null) {
            return null;
        }
        Result rootRes = helper(rootCategory);
        return res.node;
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    private Result helper(CategoryNode root) {
        if (root == null) {
            return new Result(null, 0, 0);
        }
        ArrayList<Result> results = new ArrayList<Result>();
        for (CategoryNode node :
                root.subCategoryNode) {
            results.add(helper(node));
        }

        int childSum = 0;
        int childSize = 0;
        for (Result r :
                results) {
            childSum += r.sum;
            childSize += r.size;
        }
        Result curResult = new Result(root, childSum + root.value, childSize + 1);
        if (res == null || curResult.sum * res.size > res.sum * curResult.size) {
            if (curResult.size > 1) {
                res = curResult;
            }
        }

        return curResult;
    }
}
