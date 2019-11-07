package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 14:10
 * @Description: Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 * <p>
 * Example
 * Given binary search tree:
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * Remove 3, you can either return:
 * <p>
 * 5
 * / \
 * 2   6
 * \
 * 4
 * or
 * <p>
 * 5
 * / \
 * 4   6
 * /
 * 2
 * <p>
 * {}
 * 10
 */
public class Lintcode87 {
    /*
    * @param root: The root of the binary search tree.
    * @param value: Remove the node with given value.
    * @return: The root of the binary search tree after removal.
    */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        } else {
            TreeNode dummy = new TreeNode(0);
            dummy.left = root;
            TreeNode node;
            TreeNode parent = findNode(dummy, root, value);
            if (parent.left != null && parent.left.val == value) {
                node = parent.left;
            } else if (parent.right != null && parent.right.val == value) {
                node = parent.right;
            } else {
                return dummy.left;
            }
            deleteNode(parent, node);
            return dummy.left;
        }
    }

    public TreeNode findNode(TreeNode parent, TreeNode root, int value) {
        if (root == null) {
            return parent;
        }
        if (root.val == value) {
            return parent;
        }
        if (value < root.val) {
            return findNode(root, root.left, value);
        } else {
            return findNode(root, root.right, value);
        }
    }

    public void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;

            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }

            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }

            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }

            temp.left = node.left;
            temp.right = node.right;
        }
    }


    class Pair {
        TreeNode parent;
        TreeNode node;
        //0 left 1 right
        int direction;

        public Pair(TreeNode parent, TreeNode node, int direction) {
            this.parent = parent;
            this.node = node;
            this.direction = direction;
        }
    }

    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode__(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        //先找到要删除节点的父节点
        TreeNode dummyNode = new TreeNode(0);
        dummyNode.left = root;
        helper(dummyNode.left,dummyNode,value);
//        TreeNode node;
//
//        TreeNode parent = findParent(dummyNode.left, dummyNode, value);
//        if (parent.left != null && parent.left.val == value) {
//            node = parent.left;
//        } else if (parent.right != null && parent.right.val == value) {
//            node = parent.right;
//        } else {//找不到，直接返回
//            return dummyNode.left;
//        }
//
//        //删除节点
//        deleteNode__(parent, node);
        return dummyNode.left;
    }

    public void helper(TreeNode node, TreeNode parent, int value) {
        if (node.val == value) {
            //右边找最小值
            if (node.right == null) {
                if (parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            } else {//找右分支的最小值
                TreeNode father = node;
                TreeNode temp = node.right;
                while (temp.left != null) {
                    father = temp;
                    temp = temp.left;
                }
                //解除该点和它父节点的关系
                if (father.left == temp) {
                    father.left = temp.right;
                } else {
                    father.right = temp.right;
                }

                //执行替换
                if (parent.left == node) {
                    parent.left = temp;
                } else {
                    parent.right = temp;
                }
                temp.left = node.left;
                temp.right = node.right;
            }
        } else {
            if (node.val > value && node.left != null) {
                helper(node.left, node, value);
            } else if (node.val < value && node.right != null) {
                helper(node.right, node, value);
            }
        }
    }


    public TreeNode findParent(TreeNode node, TreeNode parent, int value) {
        if (node == null) {
            return parent;
        }
        if (node.val == value) {
            return parent;
        } else {
            if (node.val > value) {
                return findParent(node.left, node, value);
            } else {
                return findParent(node.right, node, value);
            }
        }
    }

    public void deleteNode__(TreeNode parent, TreeNode node) {
        //被删除节点右子树为空
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {//被删除节点右子树不为空
            TreeNode temp = node.right;
            TreeNode father = node;
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }

            //先解除temp和原来节点的关系
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }

            //temp替换node
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }

            //原来node的子树绑到temp上
            temp.left = node.left;
            temp.right = node.right;
        }
    }

}
