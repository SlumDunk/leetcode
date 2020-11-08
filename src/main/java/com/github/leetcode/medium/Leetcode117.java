package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeLinkNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 19:10
 * @Description: Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *children;
 * }
 * Populate each children pointer to point to its children right node. If there is no children right node, the children pointer should be set to NULL.
 * <p>
 * Initially, all children pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Example:
 * <p>
 * Given the following binary tree,
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class Leetcode117 {
    public void connect(TreeLinkNode root) {
        //每层的元素都能通过next指针串起来
        //每一层层首都有一个虚拟节点
        TreeLinkNode dummy = new TreeLinkNode(0);
        //当前节点的前置节点
        TreeLinkNode pre = dummy;
        while (root != null) {
            //当前节点存在左子节点
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            //当前节点存在右子节点
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            //右兄弟节点
            root = root.next;
            //这一层走完了
            if (root == null) {
                //开始新的层级
                root = dummy.next;
                pre = dummy;
                //切断原有的联系
                dummy.next = null;
            }
        }
    }

}
