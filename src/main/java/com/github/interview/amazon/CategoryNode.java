package com.github.interview.amazon;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 4/9/19 21:28
 * @Description: 普通树节点
 */
public class CategoryNode {
    /**
     * 子节点列表
     */
    public List<CategoryNode> subCategoryNode;
    /**
     * 当前节点的值
     */
    public int value;
}
