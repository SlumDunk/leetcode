package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't
 * affect the one-to-one mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 *
 * @author liuzhongda
 */
public class Leetcode606 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String tree2str(TreeNode t) {
        StringBuilder buffer = new StringBuilder();
        //进行先根遍历
        if (t != null) {
            buffer.append(t.val);
        } else {
            return "";
        }
        //左右子树非空
        if (t.left != null && t.right != null) {
            buffer.append("(");
            buffer.append(tree2str(t.left));
            buffer.append(")");
            buffer.append("(");
            buffer.append(tree2str(t.right));
            buffer.append(")");
        }

        //左子树为空，右子树非空，左子树用空括号填充
        else if (t.left == null && t.right != null) {
            buffer.append("(");
            buffer.append(")");
            buffer.append("(");
            buffer.append(tree2str(t.right));
            buffer.append(")");

        }
        //左子树非空，右子树为空，右子树省略括号
        else if (t.left != null && t.right == null) {
            buffer.append("(");
            buffer.append(tree2str(t.left));
            buffer.append(")");
        }
        //左右子树为空，不加空括号
        else {

        }
        return buffer.toString();
    }

}
